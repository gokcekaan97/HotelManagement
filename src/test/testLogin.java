package test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.company.database;
import static com.company.RegisterScreen.*;

public class testLogin {
		String username="brsgoc";
	    String password="1234";
	    String name="baris";
	    String surname="goc";
	    int age=24;
	    String gender="Male";
	    String address="XXX";
	    database d=new database();
	    int id=1234;
	    
	@Test
	public void testLoginDetails_Positive() {
		d.registerCustomer(id,username, password, name, surname, age, gender, address);
		//The user should be able to register.
		assertTrue(d.CheckCustomerUserName(username)
				&& d.CheckCustomerPassword(password));
		d.registerEmployee(12,"kaan","abcst","kaan","gokcek",33,"male","xxx");
		//The user should be able to register.
		//assertTrue(d.CheckEmployeeUserName("kaan")&& d.CheckEmployeePassword("abcst"));
		}
	@Test
	public void testLoginDetails_Negative() {
		String username="bgoc";String password="2345";
		d.registerCustomer(id,username, password, name, surname, age, gender, address);
		//The user shouldn't be able to register.Because id is not unique.
		assertFalse(d.CheckCustomerUserName("bgoc")
				&& d.CheckCustomerPassword("23456"));
		d.registerEmployee(12,"kaan","nasvt","kaan","gokcek",42,"male","xxx");
		//The user should be able to register.
		//assertFalse(d.CheckEmployeeUserName("kaan")&& d.CheckEmployeePassword("abcst"));
		//assertFalse(d.CheckEmployeeUserName("bgoc")&& d.CheckEmployeePassword("2345"));
		assertFalse(d.CheckCustomerUserName("kaan")&& d.CheckCustomerPassword("nasvt"));
	}

}
