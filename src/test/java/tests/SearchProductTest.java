package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetaildPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {
	
	
	SearchPage searchObject;
	ProductDetaildPage detailsObject;
	String productName= "Apple MacBook Pro 13-inch";
	

	
	@Test
	public void userCanSearchForProduct() {
		driver.navigate().to("https://demo.nopcommerce.com/");
		detailsObject = new ProductDetaildPage(driver);
		searchObject = new SearchPage(driver);
		searchObject.productSearch(productName);
		searchObject.openProductDetailsPage();
		Assert.assertTrue(detailsObject.productNameReadCrumb.getText().contains("Apple MacBook Pro 13-inch"));
		
	}

}
