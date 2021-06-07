package com.example.bookreview.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bookreview.dto.ReviewDto;
import com.example.bookreview.service.NovelService;
import com.example.bookreview.service.ReviewerService;

@Controller
public class ReviewController {
	@Autowired
	private ReviewerService reviewerService;

	@Autowired
	private NovelService novelService;

	private Logger log = LoggerFactory.getLogger(ReviewController.class);

	@GetMapping("/review/new/{reviewerId}")
	public String newBookReview(@PathVariable("reviewerId") Long reviewerId, Model model, ReviewDto review) {

		review.setReviewerId(reviewerService.findReviewerById(reviewerId).getId());
		model.addAttribute("novelList", novelService.getAllNovels());
		model.addAttribute("review", review);
		return "review/create";
	}
}
