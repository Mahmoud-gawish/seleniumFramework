package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetaildPage;
import pages.SearchPage;
import pages.WhichListPage;

public class AddProductToWishListTest extends TestBase {
	
	
	
	SearchPage searchObject;
	ProductDetaildPage detailsObject;
	String productName= "Apple MacBook Pro 13-inch";
	
	WhichListPage wichObject;

	
	@Test(priority=1)
	public void userCanSearchForProduct() {
		
		detailsObject = new ProductDetaildPage(driver);
		searchObject = new SearchPage(driver);
		searchObject.productSearch(productName);
		searchObject.openProductDetailsPage();
		Assert.assertTrue(detailsObject.productNameReadCrumb.getText().contains("Apple MacBook Pro 13-inch"));
		
	}
	
	
	@Test(priority=2)
	public void addProductToWichList() throws InterruptedException {
		//detailsObject = new ProductDetaildPage(driver);
		detailsObject.addProductToWichList();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		wichObject = new WhichListPage(driver);
		Assert.assertTrue(wichObject.wichListHeadder.isDisplayed());
		Assert.assertTrue(wichObject.productCell.getText().contains(productName));
		
	}
	
	@Test(priority=3)
	public void removeProductFromWichList() {
		wichObject = new WhichListPage(driver);
		
		wichObject.removeProductFromWichList();
		Assert.assertTrue(wichObject.emptyCart.getText().contains("empty!"));
		
		
	}

}
