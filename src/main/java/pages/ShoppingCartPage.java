package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	@FindBy(name="removefromcart")
	WebElement removeFroCaartBtn;
	
	@FindBy(name="updatecart")
	WebElement updateBtn;
	
	@FindBy(css="a.product-name")
	WebElement productName;
	
	@FindBy(css="div.no-data")
	public WebElement result;
	
	@FindBy(name="itemquantity28598")
	public WebElement quentityTxt;
	
	@FindBy(css="td.subtotal")
	public WebElement totalLab;
	
	@FindBy(id ="checkout")
	WebElement checkOutBtn;
	
	@FindBy(xpath="//*[@id=\"termsofservice\"]")
	WebElement agreeCheckBox;
	
	
	public void removeFromCart() {
		clickButton(removeFroCaartBtn);
		clickButton(updateBtn);
		
		
	
	}
	
	public void updateQuantityInCart(String quantity) {
		//clear quantity
		//clearTxt(quentityTxt);
		setTextElenentText(quentityTxt, quantity);
		clickButton(updateBtn);
		
		
	}
	
	public void openCheckOutPage() {
		clickButton(agreeCheckBox);
		clickButton(checkOutBtn);
	}

}
