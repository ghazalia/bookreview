package com.example.bookreview.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "novel")
public class Novel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty (message="Book name is required")
	@Size(min = 1, message = "Book title minimum size is 1 character")
	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "writer_id", referencedColumnName = "id")
	private Author author;

	@ManyToMany
	private List<Reviewer> reviewerList;

	@OneToMany(mappedBy = "novel", cascade = CascadeType.ALL)
	private List<Review> reviews;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Reviewer> getReviewerList() {
		return reviewerList;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	@Override
	public String toString() {
		return "Novel [author=" + author + ", id=" + id + ", name=" + name + "]";
	}

}
