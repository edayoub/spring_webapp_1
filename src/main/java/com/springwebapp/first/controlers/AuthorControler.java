package com.springwebapp.first.controlers;

import com.springwebapp.first.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorControler {
    AuthorRepository authorRepository;

    public AuthorControler(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",authorRepository.findAll());
        return  "authors";
    }
}
