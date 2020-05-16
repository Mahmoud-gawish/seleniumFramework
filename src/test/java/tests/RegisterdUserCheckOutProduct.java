package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPageObjestPage;
import pages.ProductDetaildPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegistrationPage;

public class RegisterdUserCheckOutProduct extends TestBase {


	/*
	 * 1 register user
	 * 2  search product
	 * 3 add to cart
	 * 4 checkout
	 * 5 logout
	 * 
	 * 
	 * */

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetaildPage detailsObject;
	ShoppingCartPage shopingObject;
	CheckOutPage checkoutObject;
	OrderDetailsPageObjestPage orderObject;


	@Test(priority = 1,alwaysRun = true)
	public void userCanREgisterSuccessfully() {
		driver.navigate().to("https://demo.nopcommerce.com/");
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Mahmoud","Gawish", "tes77788445ldk4411f556787fdg707257755417414421881@gmail.com", "123456789");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));



	}


	@Test(priority=2)
	public void userCanSearchWithAutoSuggest() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.productSearchUsingAutoSuggest("macb");
			detailsObject = new ProductDetaildPage(driver);
			Assert.assertTrue(detailsObject.productNameReadCrumb.getText().contains("Apple MacBook Pro 13-inch"));
		} catch (Exception e) {
			System.out.println("an error ocured"+e.getMessage());
		}

	}

	@Test(priority=3)
	public void userCanAddProductToShoppingCart() throws InterruptedException {

		shopingObject = new ShoppingCartPage(driver);
		detailsObject.addToCart();
		Thread.sleep(3000);
		driver.navigate().to("https://demo.nopcommerce.com/cart");



	}

	@Test(priority=4)
	public void userCanCheckOutPriduct() throws InterruptedException {
		shopingObject.openCheckOutPage();
		checkoutObject = new CheckOutPage(driver);
		checkoutObject.registerUserCheckOutProduct("United States","djfdj", "Alaska", "2454", "245454212","fsf");
		checkoutObject.confirmOrder();
		checkoutObject.openOrderDetails();
		orderObject= new OrderDetailsPageObjestPage(driver);
		orderObject.downloadPdfInvoice();
		orderObject.printOrderDetails();


	}

	
	@Test(priority=5)
	public void registerUserCanLogout() {

		registerObject.userLogout();
	}









}
