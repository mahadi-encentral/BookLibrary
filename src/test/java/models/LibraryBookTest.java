package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryBookTest {

    LibraryBook libraryBook = new LibraryBook(
            new Book("First Title", "author one", "2020-12-12", Field.NOVEL),
            20
    );

    @BeforeEach
    void resetCopies() {
        libraryBook.setAvailableCopies(20);
        libraryBook.setTotalCopies(20);
    }

    @Test
    void testEquals() {
        assertTrue(libraryBook.equals(new Book(libraryBook.getBook().getId())));
    }

    @Test
    void isAvailable() {
        assertTrue(libraryBook.isAvailable());
        libraryBook.setAvailableCopies(0);
        assertFalse(libraryBook.isAvailable());
    }

    @Test
    void borrow() {
        int before = libraryBook.getAvailableCopies();
        libraryBook.borrow();
        libraryBook.borrow();
        assertEquals(before - 2, libraryBook.getAvailableCopies());
    }

    @Test
    void returnBook() {
        libraryBook.borrow();
        assertNotEquals(libraryBook.getAvailableCopies(), libraryBook.getTotalCopies());
        libraryBook.returnBook();
        assertEquals(libraryBook.getAvailableCopies(), libraryBook.getTotalCopies());
    }

    @Test
    void getNoOfBorrowedCopies() {
        for (int i = 0; i < 5; i++)
            libraryBook.borrow();
        assertEquals(5, libraryBook.getNoOfBorrowedCopies());
    }
}