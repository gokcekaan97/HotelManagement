package test;
import com.company.database;
import org.junit.Test;
import static org.junit.Assert.*;
import com.company.database;

public class testCheckRoom {
    database d=new database();
    int roomIndex2 = 2;
    int roomIndex3 = 3;
    @Test
    public void testRoomIsFull() {
        d.getPoint(roomIndex2);
        // yes the room is full
        assertEquals(2, d.getPoint(roomIndex2));
    }
    @Test
    public void testRoomIsEmpty() {
        // yes the room is empty
        d.getPoint(roomIndex3);
        assertNotEquals(3, d.getPoint(roomIndex3));
    }
}
