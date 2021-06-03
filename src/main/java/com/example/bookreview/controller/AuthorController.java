package com.example.bookreview.controller;

import com.example.bookreview.model.Author;
import com.example.bookreview.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/author")
    public String index(Model model) {
        model.addAttribute("authors", authorService.listAllAuthors());
        return "authors/index";
    }

    @GetMapping("author/create")
    public String create(Model model, Author author) {
        model.addAttribute("author", author);
        return "authors/create";
    }

    @PostMapping("author/create")
    public String save(Model model, Author author) {
        model.addAttribute("author", author);
        return "authors/create";
    }
}
