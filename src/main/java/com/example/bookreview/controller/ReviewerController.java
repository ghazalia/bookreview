package com.example.bookreview.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookreview.exception.DataAlreadyExistException;
import com.example.bookreview.exception.DataNotFoundException;
import com.example.bookreview.model.Reviewer;
import com.example.bookreview.service.ReviewerService;

@Controller
public class ReviewerController {
	@Autowired
	private ReviewerService reviewerService;

	@GetMapping("/reviewer/new")
	public String newReviewer(Reviewer reviewer, Model model) {
		model.addAttribute(reviewer);
		return "reviewer/create";
	}

	@PostMapping("/reviewer/new")
	public String saveNewReviewer(@Valid @ModelAttribute Reviewer reviewer, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "reviewer/create";
		}
		try {
			reviewerService.save(reviewer);
			return "reviewer/index";
		} catch (DataAlreadyExistException ex) {
			model.addAttribute("exception", ex.getMessage());
			return "reviewer/create";
		}
	}

	@GetMapping("/reviewer/view/{reviewerId}")
	public String view(@PathVariable("reviewerId") Long reviewerId, Model model, Reviewer review) {
		try {
			model.addAttribute("reviwer", reviewerService.findAuthorById(reviewerId));
			return "reviewer/view";
		} catch (DataNotFoundException ex) {
			model.addAttribute("exception", ex.getMessage());
			return "reviewer/view";
		}

	}

}
