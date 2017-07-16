package com.sej.YelpOnePointOh.engines;

import com.sej.YelpOnePointOh.views.ViewReview;

public interface IReviewEngine {
	boolean isPostInDateRange(ViewReview review, Long startDate, Long endDate);

	String getSummaryText(String text);
}
