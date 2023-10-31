package com.valtech.training.mobile.rating.ui;

import com.valtech.training.mobile.ranking.MobileRankingServiceImpl;

public class RatingHelper {
	private MobileRankingServiceImpl mobileRankingService = new MobileRankingServiceImpl();

	public int getRanking(String mobile) {
		//Validation		
		return mobileRankingService.rankMobile(mobile);
	}
}
