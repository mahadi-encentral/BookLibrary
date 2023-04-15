package library;

import models.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {

    private final ArrayList<BaseUser> initialMembers = new ArrayList<>() {
        {
            add(new Student("Isah", 1));
            add(new Student("Musah", 1));
            add(new Student("Lawwali", 4));
            add(new Staff("Mallam"));
            add(new Staff("Teacher"));
        }
    };
    private final HashMap<Book, Integer> initialShelf = new HashMap<>() {
        {
            put(new Book("Intro to Java", "Mahadi", "01-01-19999", Field.PROGRAMMING), 2);
            put(new Book("Intro to Python", "Aliyu", "01-01-19999", Field.PROGRAMMING), 2);
            put(new Book("African night Magic", "Aliyu", "01-01-19999", Field.NOVEL), 2);
            put(new Book("African night Magic II", "U Tilde", "01-01-2020", Field.NOVEL), 2);
            put(new Book("Advanced Java", "Mahadi", "01-01-19999", Field.PROGRAMMING), 2);
            put(new Book("Advanced C++ introduction", "Linus Torvald", "01-01-19999", Field.PROGRAMMING), 10);
        }
    };
    private final Library library = new Library(initialShelf, initialMembers);


    @Test
    void searchBooksByField() {
        final var result = library.searchBooksByField(Field.NOVEL);
        assertEquals(2, result.size());
        for (LibraryBook lBook : result
        ) {
            assertEquals(Field.NOVEL, lBook.getBook().getField());
        }
    }

    @Test
    void searchBooksByTitle() {
        final var result = library.searchBooksByTitle("intro");
        assertEquals(3, result.size());
        for (LibraryBook lBook : result
        ) {
            assertTrue(lBook.getBook().getTitle().toLowerCase().contains("intro"));
        }
    }

    @Test
    void searchBooksByPublishingDate() {

        final var result = library.searchBooksByPublishingDate("01-01-19999");
        assertEquals(5, result.size());
        for (LibraryBook lBook : result
        ) {
            assertEquals("01-01-19999", lBook.getBook().getPublishedDate());
        }
    }

    @Test
    void searchBooksByAuthor() {
    }

    @Test
    void allAvailableBooks() {
    }

    @Test
    void displayBooks() {
    }

    @Test
    void testDisplayBooks() {
    }

    @Test
    void borrowBook() {
    }

    @Test
    void returnBook() {
    }

    @Test
    void viewBookWaitingQue() {
    }
}