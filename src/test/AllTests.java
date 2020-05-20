package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({testAdminCheck.class,testCheckDates.class, 
	testCheckRoom.class, testGetDates.class, testLogin.class, testLoginCheck.class,testPasswordValidation.class,testRoomOwner.class})
public class AllTests {
}
