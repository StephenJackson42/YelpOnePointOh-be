package com.sej.YelpOnePointOh.converters.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sej.YelpOnePointOh.converters.IReviewConverter;
import com.sej.YelpOnePointOh.domains.DomainReview;
import com.sej.YelpOnePointOh.engines.IReviewEngine;
import com.sej.YelpOnePointOh.views.ViewReview;
import com.sej.YelpOnePointOh.domains.DomainReview;
import com.sej.YelpOnePointOh.views.ViewReview;
import com.sej.YelpOnePointOh.converters.IDateConverter;

@Service
public class ReviewConverter implements IReviewConverter {

	@Autowired
	private IDateConverter dateConverter;
	
	@Autowired
	private IReviewEngine reviewEngine;

	@Override
	public DomainReview viewToDomain(ViewReview viewReview) {
		// TODO Auto-generated method stub
		DomainReview domainReview = new DomainReview();
		domainReview.setReviewId(viewReview.getReviewId());
		domainReview.setAuthor(viewReview.getAuthor());
		domainReview.setBody(viewReview.getBody());
		domainReview.setBusinessName(viewReview.getBusinessName());
		LocalDateTime now = LocalDateTime.now();
		domainReview.setDate(now);
		domainReview.setScore(viewReview.getScore());
	
		if(viewReview.getReviewId() == null){
			domainReview.setDate(now);
		}
		else{
			domainReview.setDate(dateConverter.convertLongToLocalDateTime(viewReview.getDate()));
		}		
		return domainReview;
	}

	@Override
	public ViewReview domainToView(DomainReview domainToView) {
		// TODO Auto-generated method stub
		ViewReview viewReview = new ViewReview();
		viewReview.setReviewId(domainToView.getReviewId());
		viewReview.setAuthor(domainToView.getAuthor());
		viewReview.setBody(domainToView.getBody());
		viewReview.setBusinessName(domainToView.getBusinessName());
		viewReview.setDate(dateConverter.convertLocalDateTimeToLong(domainToView.getDate()));
		viewReview.setScore(domainToView.getScore());	
		
		return viewReview;
	}

	

}
