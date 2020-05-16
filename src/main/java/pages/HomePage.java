package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
	public Actions actions;
	public HomePage(WebDriver driver) {
		super(driver);

		//actions = new Actions(driver);
		jse= (JavascriptExecutor) driver;
	}
	//find the registration link
	@FindBy(linkText="Register")
	WebElement registerLink;
	
	@FindBy(linkText="Log in")
	WebElement loginLink;
	
	@FindBy(linkText="Contact us")
	WebElement contactUsBtn;
	
	@FindBy(id = "customerCurrency")
	WebElement currencyDropDownList;
	
	@FindBy(linkText="Computers")
	WebElement computerMenue;
	
	@FindBy(linkText="Notebooks")
	WebElement noteBoxMenue;
	
	// create method to click the registration
	public void openRegistrationPage() {
		clickButton(registerLink);
		//registerLink.click();
		
		
	}
	
	public void openLoginPage() {
		
		clickButton(loginLink);
	}
	
	public void openContactUs() {
		scrollToButtom();
		clickButton(contactUsBtn);
	}
	public void changeCurrency() {
		select =new Select(currencyDropDownList);
		select.selectByVisibleText("Euro");
		
	}
	
	public void selectNoteBoxMenue() {
		
		actions = new Actions(driver);
		actions.moveToElement(computerMenue).moveToElement(noteBoxMenue).click().build().perform();
	 
	}
	
	

}
