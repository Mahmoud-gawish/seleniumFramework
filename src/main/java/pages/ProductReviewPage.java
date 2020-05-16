package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id= "AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy(id ="AddProductReview_ReviewText")
	WebElement reviewTxt;

	
	@FindBy(id="addproductrating_4")
	WebElement rating;
	
	@FindBy(xpath="//*[@id=\"review-form\"]/form/div[2]/input")
	WebElement reviewBtn;
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/strong")
	public WebElement result;
	
	public void writeReview(String reviewTitle,String review) {
		
		setTextElenentText(reviewTitleTxt, reviewTitle);
		setTextElenentText(reviewTxt, review);
		clickButton(rating);
		clickButton(reviewBtn);
		
	}



}
