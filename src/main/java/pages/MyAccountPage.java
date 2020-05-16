package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[7]/a")
	WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxtBox;
	
	@FindBy(id = "NewPassword")
	WebElement newPasswordBox;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmPasswordBox;
	
	@FindBy(css = "input.button-1.change-password-button")
	WebElement ChangePasswordBtn;
	
	@FindBy(css= "div.result")
	public WebElement result;
	
	public void openChangePasswordPae() {
		
		clickButton(changePasswordLink);
	}
	
	public void changePassword(String oldPassword, String NewPassword) {
		
		setTextElenentText(oldPasswordTxtBox, oldPassword);
		setTextElenentText(newPasswordBox, NewPassword);
		setTextElenentText(confirmPasswordBox, NewPassword);
		clickButton(ChangePasswordBtn);
		
		
	}

}
