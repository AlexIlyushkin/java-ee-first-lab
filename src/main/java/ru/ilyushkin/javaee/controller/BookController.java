package ru.ilyushkin.javaee.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.ilyushkin.javaee.configuration.RmiClientConfiguration;
import ru.ilyushkin.javaee.entity.Book;
import ru.ilyushkin.javaee.service.BookService;

/**
 * @author Alex Ilyushkin
 */
@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(@Qualifier(RmiClientConfiguration.BOOK_SERVICE_RMI_BEAN_NAME)
                                  BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

    @GetMapping("/form")
    String form(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @PostMapping("/save")
    String save(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/book/list";
    }

    @PostMapping("/delete/{id}")
    String deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/book/list";
    }
}

