package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase{

	public CheckOutPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement firstName;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement lastName;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement emailtxt;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement country;
	
	@FindBy(id="BillingNewAddress_StateProvinceId")
	WebElement statetxt;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement cityn;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement addresstxt;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phonetxt;
	
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postCodetxt;
	
	@FindBy(xpath="//*[@id=\"billing-buttons-container\"]/input")
	WebElement continueBtn;
	/////////
	
	
	@FindBy(id="shippingoption_1")
	WebElement shoppingMethod;
	
	@FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement shoppingMethodBtn;
	////////
	
	@FindBy(xpath="//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement  continuePaymentingBtn;
	
	
	////////
	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement  continuePaymentBtn;
	//////
	//*[@id="payment-info-buttons-container"]/input
	
	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement infoBtn;
	
	///
	
	@FindBy(css="a.product-name")
	WebElement productName;
	
	//*[@id="confirm-order-buttons-container"]/input
	@FindBy(xpath="//*[@id=\"confirm-order-buttons-container\"]/input")
	WebElement confirmBtn;
	
	@FindBy(css="h1")
	public WebElement thankYou;
	
	@FindBy(css="div.title")
	public WebElement successeMeassage;
	
	////////////////////////////////////////////////
	@FindBy(linkText="Click here for order details.")
	WebElement orderDetailsLink;
	
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/input[1]")
	WebElement openCheckOutBtn;
	
	
	public void registerUserCheckOutProduct(String CountryName, String address,String stateName,
			String postcode,String phone,String city) throws InterruptedException {
		
		//first
		select = new Select(country);
		select.selectByVisibleText(CountryName);
		setTextElenentText(addresstxt,address);
		select = new Select(statetxt);
		select.selectByVisibleText(stateName);
		setTextElenentText(postCodetxt, postcode);
		setTextElenentText(phonetxt, phone);
		setTextElenentText(cityn,city);
		clickButton(continueBtn);
		Thread.sleep(3000);
		
		
		clickButton(shoppingMethodBtn);
		Thread.sleep(3000);
		
		clickButton(continuePaymentingBtn);
		Thread.sleep(3000);
		
		clickButton(continuePaymentBtn);
		Thread.sleep(3000);
		
		clickButton(confirmBtn);
		
		
		
		
	}
	
	public void confirmOrder() throws InterruptedException {
		

		
		clickButton(confirmBtn);
		
		Thread.sleep(1000);
	}
	
	
	public void openOrderDetails() {
		
		clickButton(orderDetailsLink);
	}
	
	
	public void userCheckout(String Firstn,String Lastn,String Email,String CountryName, String address,String stateName,
			String postcode,String phone,String city) throws InterruptedException {
		
		
		setTextElenentText(firstName, Firstn);
		setTextElenentText(lastName, Lastn);
		setTextElenentText(emailtxt, Email);
		select = new Select(country);
		select.selectByVisibleText(CountryName);
		setTextElenentText(addresstxt,address);
		select = new Select(statetxt);
		select.selectByVisibleText(stateName);
		setTextElenentText(postCodetxt, postcode);
		setTextElenentText(phonetxt, phone);
		setTextElenentText(cityn,city);
		clickButton(continueBtn);
		Thread.sleep(3000);
		
		
		clickButton(shoppingMethodBtn);
		Thread.sleep(3000);
		
		clickButton(continuePaymentingBtn);
		Thread.sleep(3000);
		
		clickButton(continuePaymentBtn);
		Thread.sleep(3000);
		
		clickButton(confirmBtn);
		
		
		
	}
	
	public void openCheckoutAsAgust() {
		
		clickButton(openCheckOutBtn);
	}
	
	
	
	
	

}
