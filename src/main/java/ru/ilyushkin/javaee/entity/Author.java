package ru.ilyushkin.javaee.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.StringJoiner;

/**
 * @author Alex Ilyushkin
 */
@Entity
@Table(name = "AUTHOR")
public class Author extends BaseUuidEntity implements Serializable {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Collection<Book> books;

    public Author() {
    }

    public Author(String firstName, String middleName, String lastName, Collection<Book> books) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.books = books;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Author.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("middleName='" + middleName + "'")
                .add("lastName='" + lastName + "'")
                .add("books=" + books)
                .toString();
    }
}
