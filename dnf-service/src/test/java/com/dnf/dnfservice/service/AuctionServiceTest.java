package com.dnf.dnfservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dnf.dnfservice.service.auction.AuctionService;

@SpringBootTest
public class AuctionServiceTest {
	@Autowired
	AuctionService auctionService;

	@Test
	void 경매장_검색() {
		auctionService.searchAuctionItems("무색")
			.getItems()
			.stream()
			.forEach(data -> System.out.println(data.getItemId()));
	}

}
