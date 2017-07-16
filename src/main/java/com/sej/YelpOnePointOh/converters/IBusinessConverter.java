package com.sej.YelpOnePointOh.converters;

import com.sej.YelpOnePointOh.domains.DomainBusiness;
import com.sej.YelpOnePointOh.views.ViewBusiness;

public interface IBusinessConverter {

	DomainBusiness viewToDomain (ViewBusiness viewBusiness);
	ViewBusiness domainToView (DomainBusiness domainBusiness);	
}
