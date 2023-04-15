package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StaffTest {

    @Test
    void getPriority() {
        Staff staff = new Staff("Some Staff");
        assertEquals(1, staff.getPriority());
    }
}