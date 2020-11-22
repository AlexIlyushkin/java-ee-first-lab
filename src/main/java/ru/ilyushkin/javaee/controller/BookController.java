package ru.ilyushkin.javaee.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.ilyushkin.javaee.configuration.RmiClientConfig;
import ru.ilyushkin.javaee.entity.Book;
import ru.ilyushkin.javaee.service.BookService;

/**
 * @author Alex Ilyushkin
 */
@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(@Qualifier(RmiClientConfig.BOOK_SERVICE_RMI_BEAN_NAME)
                                  BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books";
    }

    @GetMapping("/form")
    String getBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @PostMapping("/save")
    String saveBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/book/form";
    }
}

