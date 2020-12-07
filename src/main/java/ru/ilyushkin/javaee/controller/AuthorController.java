package ru.ilyushkin.javaee.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ViewResolver;
import ru.ilyushkin.javaee.configuration.RmiClientConfiguration;
import ru.ilyushkin.javaee.entity.Author;
import ru.ilyushkin.javaee.service.AuthorService;

import java.util.Collection;

/**
 * @author Alex Ilyushkin
 */
@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(@Qualifier(RmiClientConfiguration.AUTHOR_SERVICE_RMI_BEAN_NAME)
                                    AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/list")
    String list(Model model) {
        Collection<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @GetMapping("/form")
    String form(Model model) {
        model.addAttribute("author", new Author());
        return "author-form";
    }

    @PostMapping("/save")
    String save(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/author/list";
    }

    @PostMapping("/delete/{id}")
    String delete(@PathVariable Long id) {
        authorService.deleteById(id);
        return "redirect:/author/list";
    }
}
