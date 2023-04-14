package library;

import models.Field;
import models.LibraryBook;

import java.util.List;

public interface BookSearch {

    List<LibraryBook> searchBooksByAuthor(String author);
    List<LibraryBook> searchBooksByField(Field field);
    List<LibraryBook> searchBooksByTitle(String title);
    List<LibraryBook> searchBooksByPublishingDate(String date);

}
