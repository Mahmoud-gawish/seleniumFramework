package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetaildPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase{
	
	
	SearchPage searchObject;
	ProductDetaildPage detailsObject;
	ShoppingCartPage shopingObject;
	
	
	@Test(priority=1)
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
	
	
	@Test(priority=2)
	public void userCanAddProductToShoppingCart() throws InterruptedException {
		
		shopingObject = new ShoppingCartPage(driver);
		detailsObject.addToCart();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		

		
	}
	
	@Test(priority=3)
	public void userCanRemoveProductFromCart() {
		
		shopingObject.removeFromCart();
		Assert.assertTrue(shopingObject.result.getText().contains("Your Shopping Cart is empty!"));
	}
	
	@Test(priority=4,enabled=false)
	public void userCanUpdateCart() {
		
		shopingObject.updateQuantityInCart("4");
	}
	
	
	
	
	

}
