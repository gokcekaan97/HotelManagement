package test;
import static org.junit.Assert.*;
import org.junit.Test;
import com.company.database;


public class testCheckDates {
    database d = new database();
    @Test
    public void testCheckDates_Positive() {
       assertEquals("error",  d.CheckDate(1, "2020/01/15", "2020/01/25"));
       assertEquals("error",  d.CheckDate(2, "2020/02/02", "2020/02/22"));
       assertEquals("error",  d.CheckDate(3, "2020/01/22", "2020/01/24"));
       assertEquals("error",  d.CheckDate(2, "2020/01/19", "2020/01/23"));
    }
    @Test
    public void testCheckDates_Negative() {
        assertNotEquals("room is full",  d.CheckDate(1, "2020/01/07", "2020/02/25"));
        assertNotEquals("room is full",  d.CheckDate(2, "2020/01/23", "2020/02/25"));
        assertNotEquals("room is full",  d.CheckDate(3, "2020/03/12", "2020/03/19"));
        assertNotEquals("room is full",  d.CheckDate(2, "2020/01/02", "2020/01/25"));
    }
}
