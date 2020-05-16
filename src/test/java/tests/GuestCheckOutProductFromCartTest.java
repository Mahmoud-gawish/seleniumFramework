package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.OrderDetailsPageObjestPage;
import pages.ProductDetaildPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class GuestCheckOutProductFromCartTest extends TestBase {
	
	
	SearchPage searchObject;
	ProductDetaildPage detailsObject;
	ShoppingCartPage shopingObject;
	CheckOutPage checkoutObject;
	OrderDetailsPageObjestPage orderObject;
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
	public void userCanCheckOutPriduct() throws InterruptedException {
		shopingObject.openCheckOutPage();
		checkoutObject = new CheckOutPage(driver);
		checkoutObject.openCheckoutAsAgust();
		//checkoutObject.registerUserCheckOutProduct("United States","djfdj", "Alaska", "2454", "245454212","fsf");
		checkoutObject.userCheckout("mahmoud", "gawish", "dsmlsg8h@yahoo.com","United States","djfdj", "Alaska", "2454", "245454212","fsf");
		checkoutObject.confirmOrder();
		checkoutObject.openOrderDetails();
		orderObject= new OrderDetailsPageObjestPage(driver);
		orderObject.downloadPdfInvoice();
		orderObject.printOrderDetails();
		


	}
	
	

}
