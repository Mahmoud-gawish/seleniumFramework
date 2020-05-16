package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	
	@DataProvider(name="testData")
	public static Object[][] userData(){
		return new Object[][] {
			{
				"Mahmoud" , "Gawish" , "testfop@yahoo.com", "12345678"},
			    {"Ahmed","Samy","testydu@yahoo.com","12345666"}
				};
	}
	
	@Test(priority = 1,alwaysRun = true,dataProvider="testData")
	public void userCanREgisterSuccessfully(String fname,String lname,String email,String password) {
		driver.navigate().to("https://demo.nopcommerce.com/");
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(fname,lname,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		
		
		homeObject.openLoginPage();
		//loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(registerObject.logOutLink.getText().contains("Log out"));
		
		registerObject.userLogout();
	}
	
	
	
	

}
