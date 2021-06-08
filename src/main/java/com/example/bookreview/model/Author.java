package com.example.bookreview.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "writer")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message="Name is required")
	@Size(min = 3, message = "Name must be at least 3 characters")
	@Column(name = "name")
	private String name;

	@NotEmpty(message = "Must use a valid phone number")
	@Column(name = "phone")
	private String phone;

	@NotEmpty(message = "Require a valid email")
	@Email(message = "Require a valid email")
	@Column(name = "email", unique = true)
	private String email;

	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Novel> novels;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Novel> getNovels() {
		return novels;
	}

	public void setNovels(List<Novel> novels) {
		this.novels = novels;
	}

	@Override
	public String toString() {
		return "Author{" + "id=" + id + ", name='" + name + '\'' + ", phone='" + phone + '\'' + ", email='" + email
				+ '\'' + ", novels=" + getNovelTitle(this.novels) + '}';
	}

	private String getNovelTitle(List<Novel> novels) {
		for (Novel novel : novels) {
			return novel.getName().toString();
		}
		return null;
	}

}
