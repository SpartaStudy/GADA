package com.maple.mapleservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "characters")
public class Character {

	@Id
	@Column(name = "ocid", columnDefinition = "VARCHAR(200)")
	private String ocid;

	@Column(name = "date", columnDefinition = "VARCHAR(20)")
	private String date;

	@Column(name = "world_name", columnDefinition = "VARCHAR(10)")
	private String world_name;

	@Column(name = "character_name", columnDefinition = "VARCHAR(20)")
	private String character_name;

	@Column(name = "combat_power", columnDefinition = "BIGINT")
	private Long combat_power;

	@Column(name = "guild_name", columnDefinition = "VARCHAR(20)")
	private String guild_name;

	@Column(name = "parent_ocid", columnDefinition = "VARCHAR(200)")
	private String parent_ocid;

	@Column(name = "prev_name", columnDefinition = "VARCHAR(20)")
	private String prev_name;

	@Column(name = "oguild_id", columnDefinition = "VARCHAR(200)")
	private String oguild_id;

	@Column(name = "character_class", columnDefinition = "VARCHAR(20)")
	private String character_class;

	@Column(name = "character_class_level", columnDefinition = "VARCHAR(20)")
	private String character_class_level;

	@Column(name = "character_level", columnDefinition = "INT")
	private Long character_level;

	@Column(name = "character_image", columnDefinition = "VARCHAR(512)")
	private String character_image;

	@Builder
	public Character(String ocid, String date, String world_name, String character_name, Long combat_power,
		String guild_name, String parent_ocid, String prev_name, String oguild_id, String character_class,
		String character_class_level, Long character_level, String character_image) {
		this.ocid = ocid;
		this.date = date;
		this.world_name = world_name;
		this.character_name = character_name;
		this.combat_power = combat_power;
		this.guild_name = guild_name;
		this.parent_ocid = parent_ocid;
		this.prev_name = prev_name;
		this.oguild_id = oguild_id;
		this.character_class = character_class;
		this.character_class_level = character_class_level;
		this.character_level = character_level;
		this.character_image = character_image;
	}

}
