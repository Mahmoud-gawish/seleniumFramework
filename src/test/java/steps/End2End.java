package steps;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.OrderDetailsPageObjestPage;
import pages.ProductDetaildPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import tests.TestBase;


public class End2End extends TestBase{
	
	SearchPage searchpage;
	ProductDetaildPage productdetails;
	ShoppingCartPage cartpage;
	CheckOutPage checkout;
	OrderDetailsPageObjestPage orderpage;
	String productname  = "Apple MacBook Pro 13-inch";
	

	
	
	@Given("User is on Home Page")
	public void user_is_on_Home_Page() {
	    
	}

	@When("he searched for {string}")
	public void he_searched_for(String string) {
	    searchpage = new SearchPage(driver);
	    searchpage.productSearchUsingAutoSuggest(productname);
	    productdetails = new ProductDetaildPage(driver);
	    Assert.assertTrue(productdetails.productNameReadCrumb.getText().contains(productname));
	    		
	}

	@When("choose to buy two items")
	public void choose_to_buy_two_items() {
		cartpage = new ShoppingCartPage(driver);
		productdetails.addToCart();
		driver.navigate().to("https://demo.nopcommerce.com/cart");
	   
	}

	@When("move to checkout cart and enter personal details on checkout page and place the order")
	public void move_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
	  checkout = new CheckOutPage(driver);
	  cartpage.openCheckOutPage();
	  checkout.userCheckout("mahmm", "jdsjdj", "sxjsa@test.com", "Egypt", "sdssd", "Cairo", "1265", "5863258", "jhju");
	  checkout.confirmOrder();
	  
	}

	@Then("he can view the order and download the invoice")
	public void he_can_view_the_order_and_download_the_invoice() {
		orderpage = new OrderDetailsPageObjestPage(driver);
		checkout.openOrderDetails();
		orderpage.downloadPdfInvoice();
		orderpage.printOrderDetails();
	   
	}


}
