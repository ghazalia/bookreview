package com.example.bookreview.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	ReviewedKey id;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@MapsId("reviewer_id")
	@JoinColumn(name = "reviewer_id")
	private Reviewer reviewer;

	@ManyToOne
	@MapsId("novelId")
	@JoinColumn(name = "novelId")
	private Novel novel;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReviewedKey getId() {
		return id;
	}

	public void setId(ReviewedKey id) {
		this.id = id;
	}

	public Reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
	}

	public Novel getNovel() {
		return novel;
	}

	public void setNovel(Novel novel) {
		this.novel = novel;
	}
}
