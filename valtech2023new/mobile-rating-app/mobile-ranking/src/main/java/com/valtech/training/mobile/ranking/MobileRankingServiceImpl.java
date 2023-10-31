package com.valtech.training.mobile.ranking;

import java.util.List;

import com.valtech.training.pattern.checker.PatternCheckerServiceImpl;

public class MobileRankingServiceImpl implements MobileRankingService {

	private PatternCheckerServiceImpl patternCheckerService = new PatternCheckerServiceImpl();
	

	@Override
	public int rankMobile(String mobile) {
		List<String> patterns = patternCheckerService.listPatterns(mobile);
		return 0;
	}
	}

