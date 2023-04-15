package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book book1 = new Book("First Title", "author one", "2020-12-12", Field.NOVEL);
    Book book2 = new Book("First Title", "author one", "2020-12-12", Field.NOVEL);

    @Test
    void getTitle() {
        assertEquals("First Title", book1.getTitle());
    }

    @Test
    void testIdIsGeneratedDifferentForAllBooks() {
        assertNotEquals(null, book1.getId());
        assertNotEquals(book2.getId(), book1.getId());
    }

    @Test
    void testEquals() {
        assertFalse(book1.equals(book2));
        book1.setId(book2.getId());
        assertTrue(book2.equals(book1));
    }
}