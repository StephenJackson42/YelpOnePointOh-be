package com.sej.YelpOnePointOh.converters;

import com.sej.YelpOnePointOh.domains.DomainReview;
import com.sej.YelpOnePointOh.views.ViewReview;

public interface IReviewConverter {
	DomainReview viewToDomain (ViewReview viewReview);
	ViewReview domainToView (DomainReview domainReview);
}
