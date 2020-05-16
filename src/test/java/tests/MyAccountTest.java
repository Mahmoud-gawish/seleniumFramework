package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{
	
	
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	MyAccountPage myAccountObject;
	LoginPage loginObject;
	
	String oldPassword = "1234567799";
	String newPassword = "123456788";
	String firstName = "Mahmoud";
	String lastName = "Gawish";
	String email = "testnew1125801788014041@yahoo.com";
	
	
	
	@Test(priority = 1)
	public void userCanREgisterSuccessfully() {
		driver.navigate().to("https://demo.nopcommerce.com/");
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(firstName,lastName, "fkfkhc8s45d@yahoo.com", oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	
		
		
	}
	
	@Test(priority = 2)
	public void registerUserrCanChangePaswword() {
		
		myAccountObject = new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPae();
		myAccountObject.changePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.result.getText().contains("Password was changed"));
		
		
	}
	@Test(priority=3)
	public void registerUserCanLogout() {
		
		registerObject.userLogout();
	}
	
	@Test(priority=4)
	public void registerUserCanLogin() {
		
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, newPassword);
		Assert.assertTrue(registerObject.logOutLink.getText().contains("Log out"));
		
		
		
		registerObject.userLogout();
		
		
	}

}
