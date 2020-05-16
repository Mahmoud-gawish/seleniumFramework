package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(id = "FullName")
	WebElement YourNameTxtBox;
	
	@FindBy(id = "Email")
	WebElement  YourEmailTxtBox;
	
	@FindBy(id = "Enquiry")
	WebElement enquiryTxtBox;
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/input")
	WebElement submitBtn;
	
	@FindBy(css="div.result")
	public WebElement resut;
	
	public void userCanContact(String FullName, String email, String enquire) {
		
		setTextElenentText(YourNameTxtBox, FullName);
		setTextElenentText(YourEmailTxtBox, email);
		setTextElenentText(enquiryTxtBox, enquire);
		clickButton(submitBtn);
	}
	

}
