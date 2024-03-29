package com.maple.mapleservice.service.ranking;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import com.maple.mapleservice.dto.model.ranking.Guild;
import org.springframework.stereotype.Service;

import com.maple.mapleservice.dto.model.ranking.Overall;
import com.maple.mapleservice.dto.model.ranking.Union;
import com.maple.mapleservice.feign.RankingFeignClient;
import com.maple.mapleservice.util.CommonUtil;
import com.maple.mapleservice.util.cache.RedisCacheable;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankingApiServiceImpl implements RankingApiService {
	private final RankingFeignClient rankingFeignClient;

	private CommonUtil commonUtil = new CommonUtil();

	@Override
	public List<Union> getRankingUnion(String ocid, String world_name) {
		return rankingFeignClient.rankingUnionDto(ocid, commonUtil.date, world_name).getRanking();
	}

	@Override
	@RedisCacheable(value = "ranking-api-overall", key = "#world_type + '_' + #page")
	public List<Overall> getRankingOverall(int world_type, int page) {
		return rankingFeignClient.rankingOverallDto(commonUtil.date, world_type, page).getRanking();
	}

	@Override
	public List<Overall> getRankingOverall(int page) {
		return rankingFeignClient.rankingOverallDto(commonUtil.date, page).getRanking();
	}

	@Override
	@RedisCacheable(value = "ranking-api-guild", key = "#ranking_type + '_' + #world_name + '_' + #page")
	public List<Guild> getRankingGuild(String world_name, int ranking_type, int page) {
		ZonedDateTime currentDate = ZonedDateTime.now(commonUtil.getZoneId()).minusHours(1);
		ZonedDateTime mondayOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		return rankingFeignClient.rankingGuildDto(mondayOfWeek.format(commonUtil.getFormatter()), world_name, ranking_type, page).getRanking();
	}

	@Override
	public List<Guild> getGuildRankingForData(int page) {
		ZonedDateTime currentDate = ZonedDateTime.now(commonUtil.getZoneId()).minusHours(1);
		ZonedDateTime mondayOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
		return rankingFeignClient.rankingGuildDtoForData(mondayOfWeek.format(commonUtil.getFormatter()), 0, page).getRanking();
	}

}
