package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class WhichListPage extends PageBase {

	public WhichListPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(css="td.product")
	public WebElement productCell;
	
	@FindBy(css = "h1")
	public WebElement wichListHeadder;
	
	@FindBy(name = "updatecart")
	WebElement updateWichListBtn;
	
	@FindBy(name = "removefromcart")     
	WebElement removeFromCartCheck;
	
	@FindBy(css ="div.no-data")
	public WebElement emptyCart;
	
	
	public void removeProductFromWichList() {
		
		clickButton(removeFromCartCheck);
		clickButton(updateWichListBtn);
		
		
	}
	
	
	

}
