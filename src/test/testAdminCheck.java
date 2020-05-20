package test;
import com.company.database;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class testAdminCheck {
    database d = new database();
    @Test
    public void testAdminCheck_Positive() {
          assertTrue(d.adminLoginCheck("ihsan", "123456"));
    }
    @Test
    public void testAdminCheck_Negative() {
          assertFalse(d.adminLoginCheck("ihs", "123456"));
    }
}
