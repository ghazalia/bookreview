package com.example.bookreview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookreview.exception.DataAlreadyExistException;
import com.example.bookreview.exception.DataNotFoundException;
import com.example.bookreview.model.Reviewer;
import com.example.bookreview.repository.ReviewerRepository;

@Service
public class ReviewerService {
	@Autowired
	private ReviewerRepository reviewerRepo;

	public void save(Reviewer reviewer) {
		if (reviewerRepo.searchReviewerByEmail(reviewer.getEmail()).isPresent()) {
			throw new DataAlreadyExistException("This email address is not available");
		} else {
			reviewerRepo.save(reviewer);
		}
	}

	public Reviewer findAuthorById(Long reviewerId) {
		return reviewerRepo.findById(reviewerId).orElseThrow(() -> new DataNotFoundException("Data does not exist"));
	}

}
