package com.dnf.dnfservice.service.character;

import org.springframework.stereotype.Service;

import com.dnf.dnfservice.dto.feign.character.CharacterBasicInfoDto;
import com.dnf.dnfservice.dto.feign.character.CharacterEquipmentDto;
import com.dnf.dnfservice.dto.feign.character.CharacterEquipmentTraitDto;
import com.dnf.dnfservice.dto.feign.character.CharacterSearchDto;
import com.dnf.dnfservice.dto.feign.character.CharacterStatusDto;
import com.dnf.dnfservice.feign.CharacterFeignClient;
import com.dnf.dnfservice.util.cache.RedisCacheable;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CharacterApiServiceImpl implements CharacterApiService {
	private final CharacterFeignClient characterFeignClient;

	@Override
	public CharacterSearchDto searchCharacters(String characterName) {
		return characterFeignClient.searchCharacters("all", characterName, "full");
	}

	@Override
	@RedisCacheable(value = "character-api-search-characters", key = "#serverId + '_' + #characterName", expire = 600)
	public CharacterSearchDto searchCharacters(String serverId, String characterName) {
		return characterFeignClient.searchCharacters(serverId, characterName, "match");
	}

	@Override
	public CharacterBasicInfoDto getCharacterBasicInfo(String serverId, String characterId) {
		return characterFeignClient.getCharacterBasicInfo(serverId, characterId);
	}

	@Override
	public CharacterStatusDto getCharacterStatus(String serverId, String characterId) {
		return characterFeignClient.getCharacterStatus(serverId, characterId);
	}

	@Override
	public CharacterEquipmentDto getCharacterEquipment(String serverId, String characterId) {
		return characterFeignClient.getCharacterEquipment(serverId, characterId);
	}

	@Override
	public CharacterEquipmentTraitDto getCharacterEquipmentTrait(String serverId, String characterId) {
		return characterFeignClient.getCharacterEquipmentTrait(serverId, characterId);
	}
}
