package com.sej.YelpOnePointOh.domains;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class DomainReview {
	
	@Id
	@Column(name = "review_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;
	
	@Column(name = "body")
	private String body;
	
	@Column(name = "score")
	private int score;
	
	@Column(name = "author")
	private String author;
	
	

	
	@Column(name = "link")
	private String link;
	
	@ManyToOne(/*fetch =FetchType.EAGER*/)
	@JoinColumn(name ="business_id"/*, nullable = false*/)
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
		return "DomainReview [reviewId=" + reviewId + ", body=" + body + ", score=" + score + ", author=" + author
				+ ", link=" + link + ", domainBusiness=" + domainBusiness + "]";
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
		DomainReview other = (DomainReview) obj;
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
		return true;
	}

	


	
	
	
}
