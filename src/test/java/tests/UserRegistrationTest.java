package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String email = "ggfffdxgt@yahoo.com";
	String password = "258889663";
	@Test(priority = 1,alwaysRun = true)
	public void userCanREgisterSuccessfully() {
		driver.navigate().to("https://demo.nopcommerce.com/");
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Mahmoud","Gawish",email , password);
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
	

}
