package ru.ilyushkin.javaee.service;

import ru.ilyushkin.javaee.entity.Author;

import java.util.List;

/**
 * @author Alex Ilyushkin
 */

public interface AuthorService {

    List<Author> findAll();

    Author save(Author author);
}
