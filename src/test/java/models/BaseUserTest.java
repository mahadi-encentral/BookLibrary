package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseUserTest {

    private BaseUser studentUser, staffUser, seniorStudentUser;

    @BeforeEach
    void initializeUser() {
        studentUser = new Student("Student", 1);
        staffUser = new Staff("Staff");
        seniorStudentUser = new Student("Senior Student", 3);
    }

    @Test
    void getName() {
        assertEquals("Student", studentUser.getName());
        assertEquals("Staff", staffUser.getName());
        assertEquals("Senior Student", seniorStudentUser.getName());
    }


    @Test
    void setName() {
        String newName = "Some Different Name";
        seniorStudentUser.setName(newName);
        assertEquals(newName, seniorStudentUser.getName());
    }

    @Test
    void getId() {
        String id = staffUser.getId();
        assertEquals(UUID.fromString(id).toString(), id);
    }

}