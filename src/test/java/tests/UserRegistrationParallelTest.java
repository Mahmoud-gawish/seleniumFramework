package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationParallelTest extends TestBase2 {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;



	Faker fakedata = new Faker();

	String firstname = fakedata.name().firstName();
	String lastname = fakedata.name().lastName();
	String email = fakedata.internet().emailAddress();
	String pasword = fakedata.number().digits(8).toString();





	@Test(priority = 1,alwaysRun = true)
	public void userCanREgisterSuccessfully() {
		getDriver().navigate().to("https://demo.nopcommerce.com/");
		homeObject = new HomePage(getDriver());
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(getDriver());
		registerObject.userRegistration(firstname,lastname,email,pasword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));



	}
	@Test(dependsOnMethods = {"userCanREgisterSuccessfully"})
	public void registerUserCanLogout() {

		registerObject.userLogout();
	}

	@Test(dependsOnMethods = {"registerUserCanLogout"})
	public void registerUserCanLogin() {

		homeObject.openLoginPage();
		loginObject = new LoginPage(getDriver());
		loginObject.userLogin(email, pasword);
		Assert.assertTrue(registerObject.logOutLink.getText().contains("Log out"));

		registerObject.userLogout();


	}


}
