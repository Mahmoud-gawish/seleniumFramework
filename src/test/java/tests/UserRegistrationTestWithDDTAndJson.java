package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndJson extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String email = "ggfffdxgt@yahoo.com";
	String password = "258889663";
	@Test(priority = 1,alwaysRun = true)
	public void userCanREgisterSuccessfully() {
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Mahmoud","Gawish",email , password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	
		registerObject.userLogout();
		
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(registerObject.logOutLink.getText().contains("Log out"));
		
		registerObject.userLogout();
		
	}
	
	
	
	

}
