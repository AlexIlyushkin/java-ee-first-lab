package ru.ilyushkin.javaee.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.ilyushkin.javaee.entity.Author;
import ru.ilyushkin.javaee.repository.AuthorRepository;

import java.util.List;

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
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
