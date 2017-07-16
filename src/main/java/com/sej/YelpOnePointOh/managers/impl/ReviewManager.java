package com.sej.YelpOnePointOh.managers.impl;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sej.YelpOnePointOh.accessors.IReviewAccessor;
import com.sej.YelpOnePointOh.converters.IReviewConverter;
import com.sej.YelpOnePointOh.domains.DomainReview;
import com.sej.YelpOnePointOh.engines.IReviewEngine;
import com.sej.YelpOnePointOh.managers.IReviewManager;
import com.sej.YelpOnePointOh.views.ViewReview;

@Component
public class ReviewManager implements IReviewManager {

	@Autowired
	IReviewAccessor reviewAccessor;
	@Autowired
	IReviewConverter reviewConverter;
	@Autowired
	private IReviewEngine reviewEngine;
	
	@Override
	public List<ViewReview> getAllReviews() {
		return reviewAccessor.findAll().stream().map(reviewConverter::domainToView).collect(Collectors.toList());
	}

	@Override
	public ViewReview getReviewById(Long reviewId) {
		DomainReview domainReview = reviewAccessor.findOne(reviewId);
		if (domainReview == null) {
			throw new EntityNotFoundException("Unable to retrieve post: " + reviewId.toString());
		}
		return reviewConverter.domainToView(domainReview);
	}

	@Override
	public List<ViewReview> getReviewsByAuthor(String author) {
		// TODO Auto-generated method stub
		return reviewAccessor.findAllByAuthor(author).stream().map(reviewConverter::domainToView)
				.collect(Collectors.toList());
	}

	@Override
	public ViewReview createReview(ViewReview review) {
		// TODO Auto-generated method stub
		return reviewConverter.domainToView(reviewAccessor.save(reviewConverter.viewToDomain(review)));
	}

	@Override
	public ViewReview updateReview(Long reviewId, ViewReview review) {
		DomainReview currentReview = reviewAccessor.findOne(reviewId);
		if (currentReview == null) {
			throw new EntityNotFoundException("Unable to retrieve post: " + reviewId.toString());
		} else if (review.getReviewId() != reviewId) {
			throw new InvalidParameterException(
					"Provided post id: " + reviewId + " does not match provided post: " + review);
		}
		return reviewConverter.domainToView(reviewAccessor.save(reviewConverter.viewToDomain(review)));
	}

	@Override
	public ViewReview deleteReview(Long reviewId) {
		DomainReview review = reviewAccessor.findOne(reviewId);
		if (review == null) {
			throw new EntityNotFoundException("Unable to retrieve post: " + reviewId.toString());
		}
		reviewAccessor.delete(reviewId);
		return reviewConverter.domainToView(review);
	}

	@Override
	public List<ViewReview> getReviewsInDateRange(Long startDate, Long endDate) {
		return reviewAccessor.findAll().stream().map(reviewConverter::domainToView).filter(review -> {
			return reviewEngine.isPostInDateRange(review, startDate, endDate);
		}).collect(Collectors.toList());
	}

}
