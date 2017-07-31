package com.sej.YelpOnePointOh.views;

import java.util.ArrayList;
import java.util.List;

import com.sej.YelpOnePointOh.domains.DomainReview;

public class ViewBusiness {
	private Long businessId;
	private String businessName;
	private String address;
	private String website;
	private String hours;
	private String description;
	private String summaryText;
	private List<DomainReview> reviewList = new ArrayList<>();

	
	
	
	public List<DomainReview> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<DomainReview> reviewList) {
		this.reviewList = reviewList;
	}

	public String getSummaryText() {
		return summaryText;
	}

	public void setSummaryText(String summaryText) {
		this.summaryText = summaryText;
	}

	public Long getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Long business_id) {
		this.businessId = business_id;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ViewBusiness [businessId=" + businessId + ", businessName=" + businessName + ", address=" + address
				+ ", website=" + website + ", hours=" + hours + ", description=" + description + ", summaryText="
				+ summaryText + ", reviewList=" + reviewList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((businessId == null) ? 0 : businessId.hashCode());
		result = prime * result + ((businessName == null) ? 0 : businessName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((hours == null) ? 0 : hours.hashCode());
		result = prime * result + ((reviewList == null) ? 0 : reviewList.hashCode());
		result = prime * result + ((summaryText == null) ? 0 : summaryText.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewBusiness other = (ViewBusiness) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (businessId == null) {
			if (other.businessId != null)
				return false;
		} else if (!businessId.equals(other.businessId))
			return false;
		if (businessName == null) {
			if (other.businessName != null)
				return false;
		} else if (!businessName.equals(other.businessName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (hours == null) {
			if (other.hours != null)
				return false;
		} else if (!hours.equals(other.hours))
			return false;
		if (reviewList == null) {
			if (other.reviewList != null)
				return false;
		} else if (!reviewList.equals(other.reviewList))
			return false;
		if (summaryText == null) {
			if (other.summaryText != null)
				return false;
		} else if (!summaryText.equals(other.summaryText))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		return true;
	}
	
	
	
}
