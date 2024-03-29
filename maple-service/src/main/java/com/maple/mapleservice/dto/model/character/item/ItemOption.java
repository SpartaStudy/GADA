package com.maple.mapleservice.dto.model.character.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ItemOption {
    String str;
    String dex;

    @JsonProperty("int")
    String intValue;

    String luk;
    String max_hp;
    String max_mp;
    String attack_power;
    String magic_power;
    String armor;
    String speed;
    String jump;
    String boss_damage;
    String ignore_monster_armor;
    String all_stat;
    String damage;
    Integer equipment_level_decrease;
    String max_hp_rate;
    String max_mp_rate;
    Integer base_equipment_level;

}
