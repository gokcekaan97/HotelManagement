package test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.company.database;
import static com.company.RegisterScreen.*;

public class testLogin {
		String username="brsgoc";
	    String password="1234";
	    String usertype="Admin";
	    String name="baris";
	    String surname="goc";
	    int age=24;
	    String gender="Male";
	    String address="XXX";
	    database d=new database();
	    int id=1234;
	    
	@Test
	public void testLoginDetails_Positive() {
		d.registerUser(id,username, password, usertype, name, surname, age, gender, address);
		//The user should be able to register.
		assertTrue(d.CheckCustomerUserName(name)
				&& d.CheckCustomerPassword(password));
		}
	@Test
	public void testLoginDetails_Negative() {
		String username="bgoc";String password="2345";
		d.registerUser(id,username, password, usertype, name, surname, age, gender, address);
		//The user shouldn't be able to register.Because id is not unique.
		assertFalse(d.CheckCustomerUserName("bgoc")
				&& d.CheckCustomerPassword("1234"));
	}

}
