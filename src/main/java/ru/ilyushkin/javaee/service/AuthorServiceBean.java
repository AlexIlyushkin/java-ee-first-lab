package ru.ilyushkin.javaee.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.ilyushkin.javaee.entity.Author;
import ru.ilyushkin.javaee.repository.AuthorRepository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * @author Alex Ilyushkin
 */
@Service(AuthorServiceBean.NAME)
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AuthorServiceBean implements AuthorService {

    public static final String NAME = "standardAuthorService";

    private final AuthorRepository authorRepository;

    public AuthorServiceBean(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<Author> findAll() {
        List<Author> authors = authorRepository.findAll();
        authors.forEach(System.out::println);
        return authors;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public void deleteById(long authorId) {
        authorRepository.deleteById(authorId);
    }
}
