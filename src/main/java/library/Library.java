package library;

import models.Book;
import models.Field;
import models.LibraryBook;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library implements SearchableLibrary{

    private ArrayList<LibraryBook> shelf;

    public void updateShelf(Map<Book, Integer> newBooks){
        for (Map.Entry<Book, Integer> entry: newBooks.entrySet()
             ) {
            shelf.add(new LibraryBook(entry.getKey(), entry.getValue()));
        }
    }

    public List<LibraryBook> searchBooks(Predicate<LibraryBook> query){
        return shelf.stream().filter(query).collect(Collectors.toList());
    }

    @Override
    public List<LibraryBook> searchBooksByField(Field field){
        return searchBooks((lb) -> lb.getBook().getField().equals(field));
    }

    @Override
    public List<LibraryBook> searchBooksByTitle(String title) {
        return searchBooks(
                (lb) -> lb.getBook().getTitle().toLowerCase().contains(title.toLowerCase())
        );
    }

    @Override
    public List<LibraryBook> searchBooksByPublishingDate(String date) {
        return searchBooks(
                (lb) -> lb.getBook().getPublishedDate().equals(date)
        );
    }

    @Override
    public List<LibraryBook> searchBooksByAuthor(String author){
        return searchBooks(
                (lb)-> lb.getBook().getAuthor().toLowerCase().contains(author.toLowerCase())
        );
    }
}
