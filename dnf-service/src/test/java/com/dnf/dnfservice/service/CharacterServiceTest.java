package com.dnf.dnfservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dnf.dnfservice.dto.response.character.CharacterBasicInfoResponseDto;
import com.dnf.dnfservice.dto.response.character.CharacterStatResponseDto;
import com.dnf.dnfservice.entity.Characters;
import com.dnf.dnfservice.repository.character.CharactersRepository;
import com.dnf.dnfservice.service.character.CharacterService;

@SpringBootTest
class CharacterServiceTest {
	@Autowired
	CharacterService characterService;

	@Autowired
	CharactersRepository charactersRepository;

	@Test
	void 직업랭킹구하기() {
		Long rank = charactersRepository.getRankByjobAndFame("귀검사(남)", 0L);
		System.out.println(rank);
	}

	@Test
	void 캐릭터기본정보조회() {
		CharacterBasicInfoResponseDto characterBasicInfoResponseDto = characterService.getCharacterBasicInfo("카인", "aa");
		System.out.println(characterBasicInfoResponseDto.getCharacterName());
		System.out.println(characterBasicInfoResponseDto.getAdventureName());
		System.out.println(characterBasicInfoResponseDto.getJobName());
		System.out.println(characterBasicInfoResponseDto.getServerName());
		System.out.println(characterBasicInfoResponseDto.getJobRanking());
		System.out.println(characterBasicInfoResponseDto.getGuildName());
	}

	@Test
	void 캐릭터스탯조회() {
		CharacterStatResponseDto characterStatResponseDto = characterService.getCharacterStat("cain", "9b675e44d8ecbe2b7d5ac8b79e50206a");
		System.out.println(characterStatResponseDto.getBuff().size());
		System.out.println(characterStatResponseDto.getStatus().size());
	}

	@Test
	void 캐릭터db조회() {
		Characters c = charactersRepository.findByServerNameAndCharacterName("카인", "우타마루");
	}

}