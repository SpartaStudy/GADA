package com.maple.mapleservice.repository.ranking;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.maple.mapleservice.config.QuerydslConfig;
import com.maple.mapleservice.dto.response.Ranking.CharacterCombatPowerRankingResponseDto;
import static com.maple.mapleservice.entity.QCharacter.*;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.sql.JPASQLQuery;
import com.querydsl.sql.SQLExpressions;
import com.querydsl.sql.SQLTemplates;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RankingCustomRepository {
	private final QuerydslConfig querydslConfig;
	private final SQLTemplates sqlTemplates;

	@PersistenceContext
	private EntityManager entityManager;

	public Page<CharacterCombatPowerRankingResponseDto> getCombatPowerRanking(String worldName, String characterClass, Pageable pageable) {
		List<CharacterCombatPowerRankingResponseDto> content = getCharacterCombatPowerRankingResponseDto(worldName, characterClass, pageable);

		Long count = getCount(worldName, characterClass);

		return new PageImpl<>(content, pageable, count);
	}

	private List<CharacterCombatPowerRankingResponseDto> getCharacterCombatPowerRankingResponseDto(String worldName, String characterClass, Pageable pageable) {
		JPASQLQuery<?> query = new JPASQLQuery<Void>(entityManager, sqlTemplates);
		List<CharacterCombatPowerRankingResponseDto> content = query
			.select(Projections.constructor(CharacterCombatPowerRankingResponseDto.class,
				Expressions.asNumber(SQLExpressions.rank().over().orderBy(character.combat_power.desc())),
				character.ocid,
				character.world_name,
				character.character_name,
				character.combat_power,
				character.guild_name,
				character.oguild_id,
				character.character_class,
				character.character_level,
				character.character_image
				))
			.from(character)
			.where(
				worldNameEq(worldName),
				characterClassEq(characterClass)
			)
			.orderBy(character.combat_power.desc())
			.offset(pageable.getOffset())
			.limit(pageable.getPageSize())
			.fetch();

		return content;
	}

	private Long getCount(String worldName, String characterClass) {
		JPAQueryFactory query = querydslConfig.jpaQueryFactory();
		Long count = query
			.select(character.count())
			.from(character)
			.where(
				worldNameEq(worldName),
				characterClassEq(characterClass)
			)
			.fetchOne();

		return count;
	}

	private BooleanExpression characterClassEq(String characterClass) {
		return StringUtils.hasText(characterClass) ? character.character_class.eq(characterClass) : null;
	}

	private BooleanExpression worldNameEq(String worldName) {
		return StringUtils.hasText(worldName) ? character.world_name.eq(worldName) : null;
	}

}