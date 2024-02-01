package com.maple.mapleservice.service.ranking;

import com.maple.mapleservice.dto.model.ranking.Guild;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.maple.mapleservice.dto.response.Ranking.CharacterCombatPowerRankingResponseDto;

import java.util.List;

public interface RankingService {
	void addCharacterInformationFromRankingToDB(int world_type, int page);

	Page<CharacterCombatPowerRankingResponseDto> getCombatPowerRanking(String world_name, String character_class, Pageable pageable);

	List<Guild> getGuildWaterwayRanking(String world_name, int page);

}
