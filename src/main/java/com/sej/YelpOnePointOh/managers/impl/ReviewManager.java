package com.sej.YelpOnePointOh.managers.impl;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
	@Autowired
    public JavaMailSender emailSender;
	
	public void sendSimpleMessage(
		      String to, String subject, String text) {		        
		        SimpleMailMessage message = new SimpleMailMessage(); 
		        message.setTo(to); 
		        message.setSubject(subject); 
		        message.setText(text);
		        emailSender.send(message);		        
		    }
	
	
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
	public List<ViewReview> getReviewsByBusinessName(String businessName) {
		// TODO Auto-generated method stub
		return reviewAccessor.findAllByBusinessName(businessName).stream().map(reviewConverter::domainToView)
				.collect(Collectors.toList());
	}	

	@Override
	public ViewReview createReview(ViewReview review) {
		// TODO Auto-generated method stub
		sendSimpleMessage("stephenejackson93@gmail.com", "review created", review.toString());
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
		sendSimpleMessage("stephenejackson93@gmail.com", "review updated", review.toString());
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

	

}
