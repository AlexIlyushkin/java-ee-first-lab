package ru.ilyushkin.javaee.service;

import ru.ilyushkin.javaee.entity.Author;

import java.util.List;
import java.util.UUID;

/**
 * @author Alex Ilyushkin
 */

public interface AuthorService {

    List<Author> findAll();

    Author save(Author author);

    void delete(Author author);

    void deleteById(long authorId);
}
