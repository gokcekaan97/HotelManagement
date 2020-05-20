package test;
import com.company.database;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class testLoginCheck {
    database d = new database();
    @Test
    public void testAdminCheck_Positive() {
        assertTrue(d.loginCheck("ihs", "1"));
    }
    @Test
    public void testAdminCheck_Negative() {
        assertFalse(d.loginCheck("ihs", "123456"));
    }
}
