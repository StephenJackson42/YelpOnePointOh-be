package com.sej.YelpOnePointOh.managers.impl;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sej.YelpOnePointOh.accessors.IBusinessAccessor;
import com.sej.YelpOnePointOh.converters.IBusinessConverter;
import com.sej.YelpOnePointOh.domains.DomainBusiness;
//import com.sej.YelpOnePointOh.engines.IBusinessEngine;
import com.sej.YelpOnePointOh.managers.IBusinessManager;
import com.sej.YelpOnePointOh.views.ViewBusiness;

@Component
public class BusinessManager implements IBusinessManager {

	@Autowired
	IBusinessAccessor businessAccessor;	
	@Autowired
	IBusinessConverter businessConverter;	
	//@Autowired
	//IBusinessEngine businessEngine;

	@Override
	public List<ViewBusiness> getAllBusinesses() {
		
		return businessAccessor.findAll().stream().map(businessConverter::domainToView).collect(Collectors.toList());
	}

	@Override
	public ViewBusiness getBusinessById(Long businessId) {
		DomainBusiness domainBusiness = businessAccessor.findOne(businessId);
		if (domainBusiness == null) {
			throw new EntityNotFoundException("Unable to retrieve post: " + businessId.toString());
		}
		return businessConverter.domainToView(domainBusiness);
	}

	@Override
	public List<ViewBusiness> findAllByBusinessName(String businessName) {
		return businessAccessor.findAllByBusinessName(businessName).stream().map(businessConverter::domainToView).collect(Collectors.toList());
	}

	@Override
	public ViewBusiness createBusiness(ViewBusiness business) {
		return businessConverter.domainToView(businessAccessor.save(businessConverter.viewToDomain(business)));

	}

	@Override
	public ViewBusiness updateBusiness(Long businessId, ViewBusiness business) {
		DomainBusiness currentBusiness = businessAccessor.findOne(businessId);
		if (currentBusiness == null) {
			throw new EntityNotFoundException("Unable to retrieve post: " + businessId.toString());
		} else if (business.getBusinessId() != businessId) {
			throw new InvalidParameterException(
					"Provided post id: " + businessId + " does not match provided post: " + business);
		}
		return businessConverter.domainToView(businessAccessor.save(businessConverter.viewToDomain(business)));
	
	}

	@Override
	public ViewBusiness deleteBusiness(Long businessId) {
		DomainBusiness business = businessAccessor.findOne(businessId);
		if (business == null) {
			throw new EntityNotFoundException("Unable to retrieve post: " + businessId.toString());
		}
		System.out.println(businessId.toString());
		businessAccessor.delete(business);
		System.out.println(business.toString());
		return businessConverter.domainToView(business);
	}
	
	
	
}
