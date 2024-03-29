package com.maple.mapleservice.service.character;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maple.mapleservice.dto.feign.character.CharacterBasicDto;
import com.maple.mapleservice.dto.model.ranking.Union;
import com.maple.mapleservice.entity.Character;
import com.maple.mapleservice.exception.CustomException;
import com.maple.mapleservice.exception.ErrorCode;
import com.maple.mapleservice.repository.character.CharacterExpHistoryRepository;
import com.maple.mapleservice.repository.character.CharacterRepository;
import com.maple.mapleservice.service.guild.GuildApiService;
import com.maple.mapleservice.service.ranking.RankingApiService;
import com.maple.mapleservice.util.CommonUtil;
import com.maple.mapleservice.util.cache.RedisCacheEvict;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CharacterSchedule {
	private final CharacterRepository characterRepository;
	private final CharacterExpHistoryRepository characterExpHistoryRepository;
	private final CharacterApiService characterApiService;
	private final GuildApiService guildApiService;
	private final RankingApiService rankingApiService;

	private CommonUtil commonUtil = new CommonUtil();

	private final RedisTemplate redisTemplate;

	// 매일 01:00마다 실행
	@Scheduled(cron = "0 0 1 * * *", zone = "Asia/Seoul")
	public void deleteExpHistory() {
		log.info("경험치 히스토리 테이블에서 필요없는 데이터 삭제");

		List<String> distinctOcidInExpHistory = characterExpHistoryRepository.findDistinctOcidInExpHistory();
		List<Long> numbersToBeDeletedList = new ArrayList<>();
		for(String ocid : distinctOcidInExpHistory) {
			List<Long> numbersToBeRemained = characterExpHistoryRepository.findNumbersToBeRemained(ocid);
			List<Long> numbersToBeDeleted = characterExpHistoryRepository.findNumbersToBeDeleted(ocid, numbersToBeRemained);
			numbersToBeDeletedList.addAll(numbersToBeDeleted);
		}

		characterExpHistoryRepository.expHistoryBatchDelete(numbersToBeDeletedList);

		log.info(numbersToBeDeletedList.size() + "개 데이터 삭제 완료");
	}

	@Transactional
	@Scheduled(cron = "0 0/7 * * * ?")
	public void addCharacterFromRedis() {
		log.info("캐릭터 DB에 저장");

		List<Character> characterInsertList = new ArrayList<>();
		List<Character> characterUpdateList	= new ArrayList<>();
		Set<String> characterNames = redisTemplate.opsForSet().members("addCharacterToDB");;

		int count = 0;
		int limit = 1200;
		for(String characterName : characterNames) {
			String ocid = characterApiService.getOcidKey(characterName);
			if (ocid == null || ocid.isBlank()) {
				Character character = characterRepository.findByCharacterName(characterName);
				if(character != null) {
					characterRepository.deleteByCharacterName(characterName);
				}
				redisTemplate.opsForSet().remove("addCharacterToDB", characterName);
				continue;
			}

			Character character = characterRepository.findByOcid(ocid);
			if(character != null && character.getDate().equals(commonUtil.date)) {
				redisTemplate.opsForSet().remove("addCharacterToDB", characterName);
				continue;
			}

			CharacterBasicDto characterBasicDto = characterApiService.getCharacterBasic(ocid);
			if(characterBasicDto == null || characterBasicDto.getCharacter_name() == null || characterBasicDto.getCharacter_name().isBlank()) {
				redisTemplate.opsForSet().remove("addCharacterToDB", characterName);
				continue;
			}

			String combatPower = characterApiService.getCharacterStat(ocid).get("전투력");
			String oguildId = getOguildId(characterBasicDto.getCharacter_guild_name(), characterBasicDto.getWorld_name());
			List<Union> unionList = rankingApiService.getRankingUnion(ocid, characterBasicDto.getWorld_name());
			Collections.sort(unionList, (o1, o2) -> Long.compare(o2.getUnion_level(), o1.getUnion_level()));
			String parent_ocid =
				unionList.size() == 0 ? ocid : characterApiService.getOcidKey(unionList.get(0).getCharacter_name());
			if(parent_ocid == null || parent_ocid.isBlank()) {
				parent_ocid = ocid;
			}
			String prevName = "";
			if(character != null && !character.getCharacter_name().equals(characterBasicDto.getCharacter_name())) {
				prevName = character.getCharacter_name();
			}

			Character newCharacter = Character.builder()
				.ocid(ocid)
				.date(commonUtil.date)
				.world_name(characterBasicDto.getWorld_name())
				.character_name(characterBasicDto.getCharacter_name())
				.combat_power(Long.valueOf(Optional.ofNullable(combatPower).orElseGet(() -> "0")))
				.guild_name(characterBasicDto.getCharacter_guild_name())
				.parent_ocid(parent_ocid)
				.prev_name(prevName)
				.oguild_id(oguildId)
				.character_class(characterBasicDto.getCharacter_class())
				.character_class_level(characterBasicDto.getCharacter_class_level())
				.character_level(Long.valueOf(Optional.ofNullable(characterBasicDto.getCharacter_level()).orElseGet(() -> 0)))
				.character_image(characterBasicDto.getCharacter_image())
				.build();

			if(character == null) {
				characterInsertList.add(newCharacter);
			}else {
				characterUpdateList.add(newCharacter);
			}

			redisTemplate.opsForSet().remove("addCharacterToDB", characterName);

			count++;
			log.info("addCharacter " + characterName + " : " + count + " / " + limit);
			if (count == limit) {
				break;
			}
		}

		characterRepository.batchCharacterInsert(characterInsertList);
		characterRepository.batchCharacterUpdate(characterUpdateList);
	}

	// 길드명 체크해서 oguildid가져오기
	public String getOguildId(String guildName, String worldName) {
		if (guildName == null || guildName.isBlank()) {
			return "";
		}
		return guildApiService.getOguildIdKey(guildName, worldName);
	}

	// 30분마다 set -> zset 저장 : 인기 검색어
	@Transactional
	@Scheduled(cron = "0 0/30 * * * ?")
	public void addToZSetCharacterViewRank() {
		log.info("검색기록 zset에 삽입");
		Set<String> redisKeys = redisTemplate.keys("characterViewCount*");
		Objects.requireNonNull(redisKeys).forEach(
			data -> {
				String ocid = data.split("::")[1];
				Long size = redisTemplate.opsForSet().size(data);
				redisTemplate.opsForZSet().add("characterViewRank", ocid, size);
			}
		);
		//
		// log.info("캐시에서 검색기록 삭제");
		// deleteCharacterViewRankingFromCache();
	}

	// 매일 00시에 기간 만료된 인기검색어 set에서 제거
	@Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul")
	public void removeFromsetCharacterViewRank() {
		log.info("기간 만료된 검색 기록 삭제");
		Set<String> redisKeys = redisTemplate.keys("characterViewCount*");
		Objects.requireNonNull(redisKeys).forEach(
			data -> {
				Set<String> redisExpireTime = redisTemplate.opsForSet().members(data);
				redisExpireTime.stream().forEach(expire -> {
					if(LocalDateTime.parse(expire).toLocalDate().isBefore(LocalDate.now(ZoneId.of("Asia/Seoul")))) {
						redisTemplate.opsForSet().remove(data, expire);
					}
				});
			}
		);
	}
}
