package com.sej.YelpOnePointOh.views;

import com.sej.YelpOnePointOh.domains.DomainBusiness;

public class ViewReview {
	
	private Long reviewId;
	private String body;
	private int score;
	private String author;
	
	private String summary;
	private String link;
	private DomainBusiness domainBusiness;

	
	
	
	public DomainBusiness getDomainBusiness() {
		return domainBusiness;
	}
	public void setDomainBusiness(DomainBusiness domainBusiness) {
		this.domainBusiness = domainBusiness;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "ViewReview [reviewId=" + reviewId + ", body=" + body + ", score=" + score + ", author=" + author
				+ ", summary=" + summary + ", link=" + link + ", domainBusiness=" + domainBusiness + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((domainBusiness == null) ? 0 : domainBusiness.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((reviewId == null) ? 0 : reviewId.hashCode());
		result = prime * result + score;
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
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
		ViewReview other = (ViewReview) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (domainBusiness == null) {
			if (other.domainBusiness != null)
				return false;
		} else if (!domainBusiness.equals(other.domainBusiness))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (reviewId == null) {
			if (other.reviewId != null)
				return false;
		} else if (!reviewId.equals(other.reviewId))
			return false;
		if (score != other.score)
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
