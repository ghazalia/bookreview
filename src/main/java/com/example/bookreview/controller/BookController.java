package com.example.bookreview.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bookreview.exception.DataAlreadyExistException;
import com.example.bookreview.exception.DataNotFoundException;
import com.example.bookreview.model.Author;
import com.example.bookreview.model.Novel;
import com.example.bookreview.service.AuthorService;
import com.example.bookreview.service.NovelService;

@Controller
public class BookController {
	private Logger log = org.slf4j.LoggerFactory.getLogger(BookController.class);

	@Autowired
	private NovelService novelService;

	@Autowired
	private AuthorService authorService;

	@GetMapping("novel/new/{authorId}")
	public String newBook(@PathVariable("authorId") Long authorId,
						  Novel novel,
						  Model model) {
		try {
			Author author = authorService.getAuthorById(authorId);
			novel.setAuthor(author);
			model.addAttribute("novel", novel);
			return "novel/create";
		} catch (DataNotFoundException ex) {
			return "redirect: /author";
		} catch (DataAlreadyExistException ex) {
			model.addAttribute("error", ex.getMessage());
			return "/novel/create";
		}
	}

	@PostMapping("novel/new/{authorId}")
	public String save(@PathVariable("authorId") Long authorId,
					   @ModelAttribute Novel novel,
					   Model model) {
		try {
			Author author = authorService.getAuthorById(authorId);
			novel.setAuthor(author);
			novelService.saveNewNovel(authorId, novel);
			return "redirect:/author/view/" + String.valueOf(authorId);
		} catch (DataNotFoundException ex) {
			model.addAttribute("critical_error", ex.getMessage());
			return "redirect: /author";
		} catch (DataAlreadyExistException ex) {
			model.addAttribute("error", ex.getMessage());
			return "/novel/create";
		}
	}

	@GetMapping("novel/view/{bookId}")
	public String viewNovel(@PathVariable("bookId") Long bookId, Model model) {
		try {
			model.addAttribute("novel", novelService.getNovelById(bookId));
			return "novel/view";
		} catch (DataNotFoundException ex) {
			model.addAttribute("error", ex.getMessage());
			model.addAttribute("novel", new Novel());
			return "novel/view";
		}
	}
}
