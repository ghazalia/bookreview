package com.example.bookreview.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookreview.dto.ReviewDto;
import com.example.bookreview.exception.DataAlreadyExistException;
import com.example.bookreview.exception.DataNotFoundException;
import com.example.bookreview.model.Novel;
import com.example.bookreview.model.Review;
import com.example.bookreview.model.ReviewedKey;
import com.example.bookreview.model.Reviewer;
import com.example.bookreview.repository.ReviewedRepository;
import com.example.bookreview.repository.ReviewerRepository;

@Service
public class ReviewerService {
	@Autowired
	private ReviewerRepository reviewerRepo;

	@Autowired
	ReviewedRepository reviewRepo;

	@Autowired
	NovelService novelService;

	public void save(Reviewer reviewer) {
		if (reviewerRepo.searchReviewerByEmail(reviewer.getEmail()).isPresent()) {
			throw new DataAlreadyExistException("This email address is not available");
		} else {
			reviewerRepo.save(reviewer);
		}
	}

	public Reviewer findReviewerById(Long reviewerId) {
		return reviewerRepo.findById(reviewerId).orElseThrow(() -> new DataNotFoundException("Data does not exist"));
	}

	public List<Reviewer> listAllAuthors() {
		List<Reviewer> reviews = StreamSupport.stream(reviewerRepo.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return reviews;
	}

	public void saveNewReview(ReviewDto reviewDto) {
		Reviewer reviewer = this.findReviewerById(reviewDto.getReviewerId());
		Novel novel = novelService.getNovelById(reviewDto.getNovelId());

		Review review = new Review();

		review.setDescription(reviewDto.getDescription());
		review.setId(new ReviewedKey(reviewer.getId(), novel.getId()));
		review.setReviewer(reviewer);
		review.setNovel(novel);
		reviewRepo.save(review);
	}

}
