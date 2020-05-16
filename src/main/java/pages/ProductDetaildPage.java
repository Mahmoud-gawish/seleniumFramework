package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetaildPage extends PageBase {

	public ProductDetaildPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css="strong.current-item")
	public WebElement productNameReadCrumb;
	
	
	@FindBy(xpath="//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[10]/div[3]/input")
	WebElement emailAfrindLink;
	
	@FindBy(css="span.price-value-4")
	public WebElement productPriceLable;
	
	@FindBy(linkText="Add your review")
	WebElement addReviw;
	
	@FindBy(id="add-to-wishlist-button-4")   
	WebElement addToWhichListBtn;
	
	@FindBy(css="input.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;
	
	@FindBy(id ="add-to-cart-button-4")
	WebElement addToCartBtn;
	
	

	public void emailFrind() {
		
		clickButton(emailAfrindLink);
	}
	
	public void addReview() {
		
		clickButton(addReviw);
	}
	
	public void addProductToWichList() {
		//Actions action =new Actions(driver);
		//action.doubleClick(addToWhichListBtn).perform();
		clickButton(addToWhichListBtn);
	}
	
	public void addProductToCompare() {
		
		clickButton(addToCompareBtn);
	}
	
	public void addToCart() {
		
		clickButton(addToCartBtn);
	}

}
