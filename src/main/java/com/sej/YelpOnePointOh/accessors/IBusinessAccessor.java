package com.sej.YelpOnePointOh.accessors;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sej.YelpOnePointOh.domains.DomainBusiness;

public interface IBusinessAccessor extends JpaRepository<DomainBusiness, Long> {
	List<DomainBusiness> findAllByBusinessName(String businessName);
}
