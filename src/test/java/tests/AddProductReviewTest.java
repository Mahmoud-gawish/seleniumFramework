package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

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
	
	String Email = "fkff54848j@yahoo.com";
	
	ProductReviewPage reviewObject;
	
	String reviewTitle = "good product";
	String review = "the product is very good";
	
	@Test(priority = 1,alwaysRun = true)
	public void userCanREgisterSuccessfully() {
		driver.navigate().to("https://demo.nopcommerce.com/");
		
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Mahmoud","Gawish", "hgffx5zfs57fsdfrsp@yahoo.com", "123456789");
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
