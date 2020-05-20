package test;
import static org.junit.Assert.*;
import org.junit.Test;
import com.company.database;

public class testRoomOwner {
    database d = new database();
    @Test
    public void testCheckDates_Positive() {
       assertEquals("taylan",d.get(2));
    }
    @Test
    public void testCheckDates_Negative() {
        assertNotEquals("ihsan",d.get(2));
    }
}
