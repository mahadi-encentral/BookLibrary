package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentTest {

    Student student1 = new Student("Student 1", 1);
    Student student2 = new Student("Student 2", 3);

    @Test
    void getLevel() {
        assertEquals(1, student1.getLevel());
        assertEquals(3, student2.getLevel());
    }

    @Test
    void setLevel() {
        student1.setLevel(5);
        assertEquals(5, student1.getLevel());
    }

    @Test
    void isJuniorOf() {
        assertTrue(student1.isJuniorOf(student2));
    }

    @Test
    void getPriority() {
        assertEquals(7 - student1.getLevel(), student1.getPriority());
        assertEquals(7 - student2.getLevel(), student2.getPriority());
    }
}