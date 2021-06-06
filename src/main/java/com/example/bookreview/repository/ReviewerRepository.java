package com.example.bookreview.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bookreview.model.Reviewer;

@Repository
public interface ReviewerRepository extends CrudRepository<Reviewer, Long> {

	@Query("select r from Reviewer r where r.email = ?1")
	Optional<Reviewer> searchReviewerByEmail(String email);
}
