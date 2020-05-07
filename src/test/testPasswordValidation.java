package test;

import static org.junit.Assert.*;
import org.junit.Test;

public class testPasswordValidation {
	String strRegEx = "^(?=.*[0-9]).{8,15}$";
	@Test	
	public void testValidation1_P() {
		String password1="1234Brs1234_";
		String password2="_Brs_1234__";
		//This password should satisfy conditions.
	    assertTrue(password1.matches(strRegEx)?true:false);
	    assertTrue(password2.matches(strRegEx)?true:false);
	}
	@Test
	public void testValidation2_N() {
		String password2="1234";
		String password3="abcd";
		//This password shouldn't satisfy conditions.
		assertFalse(password2.matches(strRegEx)?true:false);
		assertFalse(password3.matches(strRegEx)?true:false);
	}
	
}
