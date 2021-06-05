package com.example.bookreview.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookreview.model.Author;
import com.example.bookreview.service.AuthorService;

@Controller
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	private Logger log = LoggerFactory.getLogger(AuthorController.class);

	@GetMapping("/author")
	public String index(Model model) {
		model.addAttribute("authors", authorService.listAllAuthors());
		model.addAttribute("cardTitle", "Senarai Penulis");
		return "authors/index";
	}

	@GetMapping("author/create")
	public String create(Model model, Author author) {
		model.addAttribute("author", author);
		return "authors/create";
	}

	@PostMapping("author/create")
	public String save(Model model, @ModelAttribute Author author) {
		log.info("Check ModelAttribute >>> {}", author.getName());
		log.info("Check ModelAttribute >>> {}", author.getEmail());
		log.info("Check ModelAttribute >>> {}", author.getPhone());

		try {
			authorService.save(author);
		} catch (Exception ex) {
			log.info("-----------------");
			log.info("Check Exception >>> {}", ex.toString());
			log.info("-----------------");
			model.addAttribute("error", ex.getMessage());
			model.addAttribute("author", author);
			return "authors/create";
		}
		return "redirect:/author";
	}
}
