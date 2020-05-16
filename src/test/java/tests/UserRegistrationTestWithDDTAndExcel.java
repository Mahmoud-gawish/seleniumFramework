package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndExcel extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	@DataProvider(name = "excelData")
	public Object[][] userRegisterData() throws IOException{
		// get data from x reader path
		
		ExcelReader ER = new ExcelReader();
		
			return ER.getExcelData();
		
	}
	
	
	@Test(priority = 1,alwaysRun = true,dataProvider="excelData")
	public void userCanREgisterSuccessfully(String firstname,String lastname,String email,String pasword) {
		driver.navigate().to("https://demo.nopcommerce.com/");
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(firstname,lastname,email,pasword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, pasword);
		Assert.assertTrue(registerObject.logOutLink.getText().contains("Log out"));
		registerObject.userLogout();
		
	
		
		
	}
	
	
}
		
		
	


