package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetaildPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase {


	HomePage homeObject;
	ProductDetaildPage productObject;

	SearchPage searchObject;
	ProductDetaildPage detailsObject;
	String productName= "Apple MacBook Pro 13-inch";

	@Test(priority=1)
	public void userCanChangeCurrency() {
		driver.navigate().to("https://demo.nopcommerce.com/");

		homeObject = new HomePage(driver);
		
		homeObject.changeCurrency();


	}
	@Test(priority=2)
	public void userCanSearchForProduct() {
		detailsObject = new ProductDetaildPage(driver);
		searchObject = new SearchPage(driver);
		productObject=new ProductDetaildPage(driver);
		searchObject.productSearch(productName);
		searchObject.openProductDetailsPage();
		Assert.assertTrue(productObject.productPriceLable.getText().contains("Ђ"));
		Assert.assertTrue(detailsObject.productNameReadCrumb.getText().contains("Apple MacBook Pro 13-inch"));

	}





}
