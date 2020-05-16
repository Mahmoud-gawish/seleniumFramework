package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistration extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registerObject;



	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();



	}

	@When("i click on register link")
	public void i_click_on_register_link() {

		Assert.assertTrue(driver.getCurrentUrl().contains("register"));

	}

	/*@When("i entered the user data")
	public void i_entered_the_user_data() {

		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("mahmoud", "gawish", "jsjsakdwq@yahoo.com", "12345678");

	}*/
	
	
	@When("i entered {string} , {string} , {string} , {string}")
	public void i_entered(String firstname, String lastname, String email, String password) {
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(firstname, lastname, email, password);

	}

	@Then("the registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
		registerObject.userLogout();

	}

}
