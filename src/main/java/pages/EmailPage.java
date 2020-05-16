package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id="FriendEmail")
	WebElement frindEmailTxtBox;
	
	@FindBy(id="PersonalMessage")
	WebElement personalMessageTxtBox;
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/input")
	WebElement sendEmailBtn;
	
	@FindBy(css="div.result")
	public WebElement result;
	
	
	public void senEmailToFrind(String frindEmai,String personalMessage) {
		
		setTextElenentText(frindEmailTxtBox, frindEmai);
		setTextElenentText(personalMessageTxtBox, personalMessage);
		clickButton(sendEmailBtn);
	}

}
