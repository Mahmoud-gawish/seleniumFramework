package tests;


import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndCSV extends TestBase {
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	CSVReader reader ;
	
	
	@Test(priority = 1,alwaysRun = true)
	public void userCanREgisterSuccessfully() throws CsvValidationException, IOException {
		
		// get path of scv file 
		
		String csvFile = System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData1.csv";
		
		reader = new CSVReader(new FileReader(csvFile));
		
		String[] csvCell;
		//while loop will be executed till the last value in csv file 
		
		while((csvCell =reader.readNext()) != null) {
			
			String firstname = csvCell[0];
			String lastname  = csvCell[1];
			String email = csvCell[2];
			String password  = csvCell[3];
			driver.navigate().to("https://demo.nopcommerce.com/");
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(firstname,lastname,email , password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, password);
		Assert.assertTrue(registerObject.logOutLink.getText().contains("Log out"));
		
		registerObject.userLogout();
			
		}
		
		
		
	}
	
	
	
	

}
