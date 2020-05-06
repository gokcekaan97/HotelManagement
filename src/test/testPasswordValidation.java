package test;

import static org.junit.Assert.*;
import org.junit.Test;

public class testPasswordValidation {
	String strRegEx = "^(?=.*[0-9]).{8,15}$";
	@Test	
	public void testValidation1_P() {
		String password1="1234Brs1234_";
		//This password should satisfy conditions.
	    assertTrue(password1.matches(strRegEx)?true:false);
	}
	@Test
	public void testValidation2_N() {
		String password2="1234";
		//This password shouldn't satisfy conditions.
		assertFalse(password2.matches(strRegEx)?true:false);
	}
	
}
