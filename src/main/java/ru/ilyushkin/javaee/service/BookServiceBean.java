package ru.ilyushkin.javaee.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.ilyushkin.javaee.entity.Book;
import ru.ilyushkin.javaee.repository.BookRepository;

import java.util.List;

/**
 * @author Alex Ilyushkin
 */
@Service(BookServiceBean.NAME)
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BookServiceBean implements BookService {

    public static final String NAME = "standardBookService";

    private final BookRepository bookRepository;

    public BookServiceBean(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
