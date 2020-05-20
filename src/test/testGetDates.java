package test;

import com.company.database;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class testGetDates {
    database d = new database();
    @Test
    public void testGetDates_Positive() {
        assertEquals("Room is available", d.getDate(1));
        assertEquals("Room is available", d.getDate(3));
        assertEquals("Room is available", d.getDate(4));
    }
    @Test
    public void testGetDates_Negative() {
        assertNotEquals("Room is available", d.getDate(2));
    }
}
