package ru.ilyushkin.javaee.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @author Alex Ilyushkin
 */
@Entity
@Table(name = "BOOK")
public class Book extends BaseUuidEntity implements Serializable {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "GENRE")
    private String genre;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    public Book() {
    }

    public Book(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("genre='" + genre + "'")
                .toString();
    }
}
