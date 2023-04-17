package jpaModels;

import jakarta.persistence.*;
import models.Field;

@Entity
@Table(name = "books")
public class JpaBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "author", length = 25)
    private String author;

    @Column(name = "published_date")
    private String publishedDate;

    @Column(name = "field")
    private Field field;

    public JpaBook() {
    }

    public JpaBook(long bookId, String title, String author, String publishedDate, Field field) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.field = field;
    }

    public long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
