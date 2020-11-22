package ru.ilyushkin.javaee.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.ilyushkin.javaee.configuration.RmiClientConfig;
import ru.ilyushkin.javaee.entity.Author;
import ru.ilyushkin.javaee.service.AuthorService;

/**
 * @author Alex Ilyushkin
 */
@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(@Qualifier(RmiClientConfig.AUTHOR_SERVICE_RMI_BEAN_NAME)
                                    AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list")
    String list(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }

    @GetMapping("/form")
    String getForm(Model model) {
        model.addAttribute("author", new Author());
        return "author-form";
    }

    @PostMapping("/save")
    String save(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/author/form";
    }
}
