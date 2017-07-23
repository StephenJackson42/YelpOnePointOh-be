package com.sej.YelpOnePointOh.accessors;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sej.YelpOnePointOh.domains.DomainReview;

public interface IReviewAccessor extends JpaRepository<DomainReview, Long> {
	List<DomainReview> findAllByBusinessName(String businessName);
}
