package com.example.bookreview.dto;

public class ReviewDto {
	private Long ReviewerId;

	private String description;

	private Long novelId;

	public Long getReviewerId() {
		return ReviewerId;
	}

	public void setReviewerId(Long reviewerId) {
		ReviewerId = reviewerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getNovelId() {
		return novelId;
	}

	public void setNovelId(Long novelId) {
		this.novelId = novelId;
	}

}
