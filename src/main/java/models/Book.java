package models;

import java.util.UUID;

public class Book {
    private String id;
    private  String title;
    private String author;
    private String publishedDate;
    private  Field field;


    public Book(String title, String author, String publishedDate, Field field) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.field = field;
    }


    public Book(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "ID:\t%s%nTitle:\t%s%nField:\t%s%nAuthor:\t%s%nPublished date:\t%s%n",
                id, title, field, author, publishedDate
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean equals(Book b){
        return id.equals(b.getId());
    }
}
