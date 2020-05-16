package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetaildPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase {
	
	
	
	
	
	String firstProductNamr = "macb";
	String seconProductName = "Asu";
	
	//1- search for product no 1
	//2- search for product no 2
	//3-add to compare
	//4-clear list
	
	ProductDetaildPage detalisObject;
	HomePage homeObject;
	ComparePage compareObject;
	SearchPage searchObject;
	
	@Test(priority=1)
	public void userCanCompareProducts() throws InterruptedException {
		driver.navigate().to("https://demo.nopcommerce.com/");
		
		detalisObject = new ProductDetaildPage(driver);
		searchObject = new SearchPage(driver);
		compareObject = new ComparePage(driver);
		
		searchObject = new SearchPage(driver);
		searchObject.productSearchUsingAutoSuggest(firstProductNamr);
		detalisObject = new ProductDetaildPage(driver);
		Assert.assertTrue(detalisObject.productNameReadCrumb.getText().contains("Apple MacBook Pro 13-inch"));
		detalisObject.addProductToCompare();
		
		//Thread.sleep(4000);
		
		
		searchObject = new SearchPage(driver);
		searchObject.productSearchUsingAutoSuggest(seconProductName);
		detalisObject = new ProductDetaildPage(driver);
		Assert.assertTrue(detalisObject.productNameReadCrumb.getText().contains("Asus N551JK-XO076H Laptop"));
		detalisObject.addProductToCompare();
		
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");
		compareObject.compareProduct();
		
		
	}
	
	@Test(priority=2)
	public void userCanClearCompareList() {
		
		compareObject.clearCompareTable();
	}

}
