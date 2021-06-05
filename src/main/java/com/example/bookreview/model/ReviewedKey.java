package com.example.bookreview.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class ReviewedKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "novel_id")
	private Long novelId;

	@Column(name = "reviewer_id")
	private Long reviewerId;

	public Long getNovelId() {
		return novelId;
	}

	public void setNovelId(Long novelId) {
		this.novelId = novelId;
	}

	public Long getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Long reviewerId) {
		this.reviewerId = reviewerId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ReviewedKey))
			return false;
		ReviewedKey that = (ReviewedKey) o;
		return getNovelId().equals(that.getNovelId()) && getReviewerId().equals(that.getReviewerId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNovelId(), getReviewerId());
	}
}
