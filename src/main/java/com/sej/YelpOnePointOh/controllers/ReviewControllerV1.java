package com.sej.YelpOnePointOh.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sej.YelpOnePointOh.managers.IReviewManager;
import com.sej.YelpOnePointOh.views.ViewReview;


@RestController
@RequestMapping("/api/v1/review")
public class ReviewControllerV1 {
	
	@Autowired
	IReviewManager reviewManager;
	
	@RequestMapping (method = RequestMethod.GET)
	ResponseEntity<List<ViewReview>> getAllReviews() {
	return new ResponseEntity<>(reviewManager.getAllReviews(),
	HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{reviewId}", method = RequestMethod.GET)
	ResponseEntity<ViewReview> getReview(@PathVariable Long reviewId) {
		return new ResponseEntity<>( reviewManager.getReviewById(reviewId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	List<ViewReview> getReviewsByParams(
			@RequestParam(value = "businessName", required = false) String businessName) {
		if (businessName != null) {
			return reviewManager.getReviewsByBusinessName(businessName);
		} else {
			return Collections.emptyList();
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	ResponseEntity<ViewReview> createReview(@RequestBody ViewReview review) {
		return new ResponseEntity<>( reviewManager.createReview(review), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{reviewId}", method = RequestMethod.DELETE)
	ResponseEntity<ViewReview> deleteReview(@PathVariable Long reviewId) {
		return new ResponseEntity<>( reviewManager.deleteReview(reviewId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{reviewId}", method = RequestMethod.PUT)
	ResponseEntity<ViewReview> updateReview(@PathVariable Long reviewId, @RequestBody ViewReview review) {
		return new ResponseEntity<>( reviewManager.updateReview(reviewId,review), HttpStatus.OK);
	}

}
