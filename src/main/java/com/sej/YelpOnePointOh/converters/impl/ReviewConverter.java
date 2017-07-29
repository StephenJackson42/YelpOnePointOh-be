package com.sej.YelpOnePointOh.converters.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sej.YelpOnePointOh.converters.IReviewConverter;
import com.sej.YelpOnePointOh.domains.DomainReview;
import com.sej.YelpOnePointOh.engines.IReviewEngine;
import com.sej.YelpOnePointOh.views.ViewReview;

@Service
public class ReviewConverter implements IReviewConverter {

	
	
	@Autowired
	private IReviewEngine reviewEngine;

	@Override
	public DomainReview viewToDomain(ViewReview viewReview) {
		DomainReview domainReview = new DomainReview();
		domainReview.setReviewId(viewReview.getReviewId());
		domainReview.setAuthor(viewReview.getAuthor());
		domainReview.setBody(viewReview.getBody());
		domainReview.setBusinessName(viewReview.getBusinessName());
		domainReview.setScore(viewReview.getScore());
		domainReview.setLink(viewReview.getLink());
	
		return domainReview;
	}

	@Override
	public ViewReview domainToView(DomainReview domainToView) {
		ViewReview viewReview = new ViewReview();
		viewReview.setReviewId(domainToView.getReviewId());
		viewReview.setAuthor(domainToView.getAuthor());
		viewReview.setBody(domainToView.getBody());
		viewReview.setBusinessName(domainToView.getBusinessName());
		viewReview.setScore(domainToView.getScore());	
		viewReview.setSummary(reviewEngine.getSummaryText(viewReview.getBody()));
		viewReview.setLink(domainToView.getLink());
		return viewReview;
	}

	

}
