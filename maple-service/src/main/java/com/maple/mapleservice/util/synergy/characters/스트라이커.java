package com.maple.mapleservice.util.synergy.characters;

import java.util.List;

import com.maple.mapleservice.dto.model.synergy.StatWeightForCalculate;
import com.maple.mapleservice.dto.model.synergy.SynergySkill;
import com.maple.mapleservice.dto.model.synergy.IncreaseVolume;

import lombok.Getter;

@Getter
public class 스트라이커 {
	String character_class = "스트라이커";
	Integer cycle = 2;
	List<String> skill_type = List.of("공격 속도");
	List<SynergySkill> skill_desc = List.of(
		new SynergySkill(
			"윈드 부스터",
			"자신과 파티원의 공격 속도를 증가시킨다. 기존 부스터와 중복해서 사용할 수 있다. 추가로 해파를 강화한다.\n필요 스킬 : 너클 액셀레이션 5레벨 이상",
			"HP 40, MP 40 소비, 300초 동안 공격 속도 2단계 증가\n[패시브 효과 : 해파의 데미지 100%p 증가]",
			"https://open.api.nexon.com/static/maplestory/SkillIcon/KFOHKFPBMF.png"
		)
	);

	IncreaseVolume increaseVolume = IncreaseVolume.builder()
		.plus_str(0)
		.plus_dex(0)
		.plus_int(0)
		.plus_luk(0)
		.plus_hp(0)
		.multiply_str(1.0)
		.multiply_dex(1.0)
		.multiply_int(1.0)
		.multiply_luk(1.0)
		.multiply_hp(1.0)
		.multiply_ap_str(1.0)
		.multiply_ap_dex(1.0)
		.multiply_ap_int(1.0)
		.multiply_ap_luk(1.0)
		.multiply_ap_hp(1.0)
		.plus_attack_power(0)
		.plus_magic_power(0)
		.multiply_attack_power(1.0)
		.multiply_magic_power(1.0)
		.plus_boss_damage(0)
		.plus_damage(0)
		.plus_final_damage(0)
		.plus_critical_damage(0)
		.build();

	StatWeightForCalculate statWeightForCalculate = StatWeightForCalculate.builder()
		.rate_str(4.0)
		.rate_dex(1.0)
		.rate_int(0.0)
		.rate_luk(0.0)
		.rate_hp(0.0)
		.rate_attack_power(1.0)
		.rate_magic_power(0.0)
		.build();
}
