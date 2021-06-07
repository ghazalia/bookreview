package com.example.bookreview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bookreview.model.Reviewer;
import com.example.bookreview.service.NovelService;
import com.example.bookreview.service.ReviewerService;

@Controller
public class ReviewController {
	@Autowired
	private ReviewerService reviewerService;

	@Autowired
	private NovelService novelService;

	@GetMapping("/review/new/{reviewerId}")
	public String newBookReview(@PathVariable("reviewerId") Long reviewerId, Model model, Reviewer reviewer) {
		model.addAttribute("novels", novelService.getAllNovels());
		model.addAttribute("reviewer", reviewerService.findReviewerById(reviewerId));
		return "review/create";
	}
}
