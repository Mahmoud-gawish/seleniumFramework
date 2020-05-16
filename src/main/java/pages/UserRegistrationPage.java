package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	// find all the elements for make a registration
	@FindBy(id= "gender-male")
	WebElement genderRadio;

	@FindBy(id="FirstName")
	WebElement fnTxtBox;

	@FindBy(id="LastName")
	WebElement lnTxtBox;

	@FindBy(id="Email")
	WebElement emailTxtBox;

	@FindBy(id="Password")
	WebElement passwordTxtBox;

	@FindBy(id="ConfirmPassword")
	WebElement confirmpassword;

	@FindBy(id="register-button")
	WebElement registerBtn;

	@FindBy(css="div.result")
	public WebElement successMessage;
	
	@FindBy(css="a.ico-logout")
	public WebElement logOutLink;
	
	@FindBy(linkText="My account")
	WebElement myAccountLink;

	//create a method to register 
	public void userRegistration(String firsName, String lastName, String email, String passwrod) {

		clickButton(genderRadio);
		setTextElenentText(fnTxtBox, firsName);
		setTextElenentText(lnTxtBox, lastName);
		setTextElenentText(emailTxtBox, email);
		setTextElenentText(passwordTxtBox, passwrod);
		setTextElenentText(confirmpassword, passwrod);
		clickButton(registerBtn);
	}
	public void userLogout() {
		
		
		clickButton(logOutLink);
	}
	
	public void openMyAccountPage() {
		
		clickButton(myAccountLink);
	}

}
