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

import com.sej.YelpOnePointOh.managers.IBusinessManager;
import com.sej.YelpOnePointOh.views.ViewBusiness;


@RestController
@RequestMapping("/api/v1/business")
public class BusinessControllerV1 {

	@Autowired
	IBusinessManager businessManager;
	
	@RequestMapping (method = RequestMethod.GET)
	ResponseEntity<List<ViewBusiness>> getAllBusinesses() {
	return new ResponseEntity<>(businessManager.getAllBusinesses(),
	HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{businessId}", method = RequestMethod.GET)
	ResponseEntity<ViewBusiness> getReview(@PathVariable Long businessId) {
		return new ResponseEntity<>( businessManager.getBusinessById(businessId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	List<ViewBusiness> getReviewsByParams(
			@RequestParam(value = "website", required = false) String businessName) {
		if (businessName != null) {
			return businessManager.findAllByBusinessName(businessName);
		} else {
			return Collections.emptyList();
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	ResponseEntity<ViewBusiness> createBusiness(@RequestBody ViewBusiness business) {
		return new ResponseEntity<>( businessManager.createBusiness(business), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{businessId}", method = RequestMethod.DELETE)
	ResponseEntity<ViewBusiness> deleteBusniess(@PathVariable Long businessId) {
		return new ResponseEntity<>( businessManager.deleteBusiness(businessId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{businessId}", method = RequestMethod.PUT)
	ResponseEntity<ViewBusiness> updateReview(@PathVariable Long businessId, @RequestBody ViewBusiness business) {
		return new ResponseEntity<>( businessManager.updateBusiness(businessId,business), HttpStatus.OK);
	}
	



}


