package test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.company.database;
import static com.company.RegisterScreen.*;

public class testLogin {
	    database d=new database();
	    
	@Test
	public void testLoginDetails_Positive() {
		//The user should be able to register.
		d.registerCustomer(1234,"brsgoc","1234","baris","goc",24, "Male","xxx");
		assertTrue(d.CheckCustomerUserName("brsgoc")&& d.CheckCustomerPassword("1234"));
		d.registerEmployee(12,"kaan","abcst","kaan","gokcek",33,"male","xxx");
		assertTrue(d.CheckEmployeeUserName("kaan")&& d.CheckEmployeePassword("abcst"));
		}
	@Test
	public void testLoginDetails_Negative() {
		//The user shouldn't be able to register.Because ids are not unique.
		d.registerCustomer(1234,"bgoc","2345","baris","goc", 30,"Male","XXX");
		d.registerEmployee(12,"kaan","nasvt","kaan","gokcek",42,"male","xxx");
		
		assertFalse(d.CheckCustomerUserName("bgoc")&& d.CheckCustomerPassword("2345"));
		assertFalse(d.CheckEmployeeUserName("kaan")&& d.CheckEmployeePassword("nasvt"));
		assertFalse(d.CheckEmployeeUserName("bgoc")&& d.CheckEmployeePassword("2345"));
		assertFalse(d.CheckCustomerUserName("kaan")&& d.CheckCustomerPassword("nasvt"));
	}

}
