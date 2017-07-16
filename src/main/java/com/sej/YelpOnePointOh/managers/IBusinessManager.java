package com.sej.YelpOnePointOh.managers;

import java.util.List;

import com.sej.YelpOnePointOh.views.ViewBusiness;


public interface IBusinessManager {
	List<ViewBusiness> getAllBusinesses();
	ViewBusiness getBusinessById(Long businessId);
	List<ViewBusiness> findAllByBusinessName(String businessName);
	ViewBusiness createBusiness(ViewBusiness business);
	ViewBusiness updateBusiness(Long businessId, ViewBusiness business);
	ViewBusiness deleteBusiness(Long businessId);
}
