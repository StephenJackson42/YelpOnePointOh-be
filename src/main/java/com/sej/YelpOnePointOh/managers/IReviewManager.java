package com.sej.YelpOnePointOh.managers;

import java.util.List;

import com.sej.YelpOnePointOh.views.ViewReview;

public interface IReviewManager {
	List<ViewReview> getAllReviews();
	ViewReview getReviewById(Long reviewId);
	List<ViewReview> getReviewsByBusinessName(String businessName);
	ViewReview createReview(ViewReview review);
	ViewReview updateReview(Long reviewId, ViewReview review);
	ViewReview deleteReview(Long reviewId);
	
	
}
