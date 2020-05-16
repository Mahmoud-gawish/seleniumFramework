package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.ProductDetaildPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFrindTest extends TestBase{
	
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	EmailPage emailobject;
	SearchPage searchObject;
	
	ProductDetaildPage detailsObject;
	String productName= "Apple MacBook Pro 13-inch";
	String myEmail = "teast58dki857787o@yahoo.com";
	String frindEmail = "mahdxdk@yahoo.com";
	String personalMessage ="this product is very good";
	
	
	
	@Test(priority = 1,alwaysRun = true)
	public void userCanREgisterSuccessfully() {
		driver.navigate().to("https://demo.nopcommerce.com/");
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Mahmoud","Gawish", "jgd8cdxsfgd45jap@yahoo.com", "123456789");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	
		
		
	}
	
	@Test(priority=2)
	public void userCanSearchForProduct() {
		detailsObject = new ProductDetaildPage(driver);
		searchObject = new SearchPage(driver);
		searchObject.productSearch(productName);
		searchObject.openProductDetailsPage();
		Assert.assertTrue(detailsObject.productNameReadCrumb.getText().contains("Apple MacBook Pro 13-inch"));
		
	}
	
	@Test(priority=3)
	public void userCanEmailFrind() {
		
		emailobject = new EmailPage(driver);
		detailsObject.emailFrind();
		emailobject.senEmailToFrind(frindEmail,personalMessage );
		
		Assert.assertTrue(emailobject.result.getText().contains("Your message has been sent"));
		
		
		registerObject.userLogout();
		
		
		
	}
		
	}
	
	
	


