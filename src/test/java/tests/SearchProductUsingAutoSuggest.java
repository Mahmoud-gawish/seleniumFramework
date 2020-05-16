package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetaildPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase{
	
	SearchPage searchObject;
	ProductDetaildPage detailsObject;
	
	
	@Test
	public void userCanSearchWithAutoSuggest() {
		try {
			driver.navigate().to("https://demo.nopcommerce.com/");
			searchObject = new SearchPage(driver);
			searchObject.productSearchUsingAutoSuggest("macb");
			detailsObject = new ProductDetaildPage(driver);
			Assert.assertTrue(detailsObject.productNameReadCrumb.getText().contains("Apple MacBook Pro 13-inch"));
		} catch (Exception e) {
		System.out.println("an error ocured"+e.getMessage());
		}
		
	}

}
