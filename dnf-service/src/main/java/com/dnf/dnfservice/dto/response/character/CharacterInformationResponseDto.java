package com.dnf.dnfservice.dto.response.character;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterInformationResponseDto {
	CharacterBasicInfoResponseDto basic;
	CharacterStatResponseDto stat;
	CharacterEquipmentResponseDto equipment;
	CharacterBuffResponseDto buff;
	CharacterSkillResponseDto skill;

	public static CharacterInformationResponseDto of(CharacterBasicInfoResponseDto basic, CharacterStatResponseDto stat,
		CharacterEquipmentResponseDto equipment, CharacterBuffResponseDto buff, CharacterSkillResponseDto skill) {
		return CharacterInformationResponseDto.builder()
			.basic(basic)
			.stat(stat)
			.equipment(equipment)
			.buff(buff)
			.skill(skill)
			.build();
	}

}
