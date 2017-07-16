package com.sej.YelpOnePointOh.engines.impl;

import org.springframework.stereotype.Service;

import com.sej.YelpOnePointOh.engines.IBusinessEngine;

@Service
public class BusinessEngine implements IBusinessEngine {
	
	private static final Integer SUMMARY_LENGTH = 256;

	

	@Override
	public String getSummaryText(String text) {
		if (text != null && text.length() > SUMMARY_LENGTH) {
			return text.substring(0, SUMMARY_LENGTH);
		}
		return text;
	}
}
