package ru.ilyushkin.javaee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.ilyushkin.javaee.entity.Author;

import java.util.UUID;

/**
 * @author Alex Ilyushkin
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
