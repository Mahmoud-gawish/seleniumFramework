package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;


public class ContactUsTest extends TestBase{
	
	
	HomePage homeObject;
	ContactUsPage contacyObject;
	
	
	String fullName = "Mahmoud GAwish";
	String email= "masjds54sddsk@yahoo.com";
	String enquire = "could i have the details plz";
	
	
	
	@Test
	public void userCanContact() {
		
		driver.navigate().to("https://demo.nopcommerce.com/");
		homeObject = new HomePage(driver);
		homeObject.openContactUs();
		contacyObject = new ContactUsPage(driver);
		contacyObject.userCanContact(fullName,email, enquire);
		Assert.assertTrue(contacyObject.resut.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}

}
