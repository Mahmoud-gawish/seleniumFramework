package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationDDTAndProperitesFile extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	String firstname = LoadProperties.userDate.getProperty("firstname");
	String lastname = LoadProperties.userDate.getProperty("lastname");
	String email  = LoadProperties.userDate.getProperty("email");
	String password = LoadProperties.userDate.getProperty("password");
	
	@Test(priority = 1,alwaysRun = true)
	public void userCanREgisterSuccessfully() {
		driver.navigate().to("https://demo.nopcommerce.com/");
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(firstname,lastname,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	
		
		
	}
	@Test(dependsOnMethods = {"userCanREgisterSuccessfully"})
	public void registerUserCanLogout() {
		
		registerObject.userLogout();
	}
	
	@Test(dependsOnMethods = {"registerUserCanLogout"})
	public void registerUserCanLogin() {
		
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(registerObject.logOutLink.getText().contains("Log out"));
		
		registerObject.userLogout();
		
		
	}
	public static void main(String[] args) {
		
	}

}
