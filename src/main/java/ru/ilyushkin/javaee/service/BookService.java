package ru.ilyushkin.javaee.service;

import ru.ilyushkin.javaee.entity.Book;

import java.util.List;

/**
 * @author Alex Ilyushkin
 */
public interface BookService {

    List<Book> findAll();

    Book save(Book book);

    void delete(Book book);

    void deleteById(Long id);
}
