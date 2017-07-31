package com.sej.YelpOnePointOh.converters.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sej.YelpOnePointOh.converters.IBusinessConverter;
import com.sej.YelpOnePointOh.domains.DomainBusiness;
import com.sej.YelpOnePointOh.domains.DomainReview;
import com.sej.YelpOnePointOh.engines.IBusinessEngine;
import com.sej.YelpOnePointOh.views.ViewBusiness;

@Service
public class BusinessConverter implements IBusinessConverter {
	
	@Autowired
	private IBusinessEngine businessEngine;

	@Override
	public DomainBusiness viewToDomain(ViewBusiness viewBusiness) {
		DomainBusiness domainBusiness = new DomainBusiness();
		domainBusiness.setBusinessId(viewBusiness.getBusinessId());
		domainBusiness.setBusinessName(viewBusiness.getBusinessName());
		domainBusiness.setAddress(viewBusiness.getAddress());
		domainBusiness.setWebsite(viewBusiness.getWebsite());
		domainBusiness.setHours(viewBusiness.getHours());
		domainBusiness.setDescription(viewBusiness.getDescription());
		domainBusiness.setReviewList(viewBusiness.getReviewList());
		
		for (int i = 0 ; domainBusiness.getReviewList().size() < 0 ; i++  ){
			domainBusiness.getReviewList().get(i).setDomainBusiness(null);
		}
		
		return domainBusiness;
	}

	@Override
	public ViewBusiness domainToView(DomainBusiness domainBusiness) {
		ViewBusiness viewBusiness = new ViewBusiness();
		viewBusiness.setBusinessId(domainBusiness.getBusinessId());
		viewBusiness.setBusinessName(domainBusiness.getBusinessName());
		viewBusiness.setAddress(domainBusiness.getAddress());
		viewBusiness.setWebsite(domainBusiness.getWebsite());
		viewBusiness.setHours(domainBusiness.getHours());
		viewBusiness.setDescription(domainBusiness.getDescription());
		viewBusiness.setSummaryText(businessEngine.getSummaryText(viewBusiness.getDescription()));
		viewBusiness.setReviewList(domainBusiness.getReviewList());
		
		/*for (int i=0; viewBusiness.getReviewList().size() < 0; i++){
			viewBusiness.getReviewList().get(i).setDomainBusiness(null);
		}
		*/
		for(DomainReview review:viewBusiness.getReviewList()){
			review.setDomainBusiness(null);
		}
		
		
		
		return viewBusiness;
		
		
	}
	
	
}
