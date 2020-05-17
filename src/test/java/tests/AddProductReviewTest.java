package tests;

import javax.crypto.spec.OAEPParameterSpec;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.ProductDetaildPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase{
	
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	SearchPage searchObject;
	ProductDetaildPage detailsObject;
	String productName= "Apple MacBook Pro 13-inch";
	
	Faker fakedata = new Faker();

	String firstname = fakedata.name().firstName();
	String lastname = fakedata.name().lastName();
	String email = fakedata.internet().emailAddress();
	String pasword = fakedata.number().digits(8).toString();

	
	ProductReviewPage reviewObject;
	
	String reviewTitle = "good product";
	String review = "the product is very good";
	
	@Test(priority = 1,alwaysRun = true)
	public void userCanREgisterSuccessfully() {
		
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(firstname,lastname,email,pasword);
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
	public void userCanReviewProduct() {
		
		reviewObject = new ProductReviewPage(driver);
		detailsObject.addReview();
		reviewObject.writeReview(reviewTitle, review);
		Assert.assertTrue(reviewObject.result.getText().contains(reviewTitle));
		
		
		
		//registerObject.userLogout();
		
		
		
		
	}
	
	
	
}
