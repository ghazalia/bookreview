package com.example.bookreview.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookreview.exception.DataNotFoundException;
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

	@GetMapping("/author/edit/{authorId}")
	public String editAuthor(@PathVariable("authorId") Long authorId, Model model, Author author) {
		try {
			author = authorService.getAuthorById(authorId);
			model.addAttribute("author", author);
			return "authors/edit";
		} catch (DataNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
			return "authors/edit";
		}
	}

	@PostMapping("/author/edit/{authorId}")
	public String updateAuthor(@PathVariable("authorId") Long authorId, Model model, @ModelAttribute Author author) {
		try {
			author.setId(authorId);
			authorService.updateAuthor(author);
			return "redirect:/author/view/" + String.valueOf(author.getId());
		} catch (DataNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
			author.setId(authorId);
			model.addAttribute("author", author);
			return "authors/edit/";
		}
	}

	@GetMapping("/author/view/{authorId}")
	public String viewAuthor(@PathVariable("authorId") Long authorId, Model model) {
		try {
			model.addAttribute("author", authorService.getAuthorById(authorId));
			return "authors/view";
		} catch (DataNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
			model.addAttribute("author", new Author());
			return "authors/view";
		}
	}

	@GetMapping("/author/delete/{authorId}")
	public String deleteAuthor(@PathVariable("authorId") Long authorId, Model model) {
		try {
			authorService.delete(authorId);
			model.addAttribute("success", "Data was deleted");

		} catch (Exception ex) {
			model.addAttribute("error", ex.getMessage());

		}
		return "authors/index";
	}

}
