package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenueTest extends TestBase{
	
	HomePage homeObject;
	
	@Test
	public void userCanSelectSubcategoryFromHomeMenue() {
		driver.navigate().to("https://demo.nopcommerce.com/");
		homeObject = new HomePage(driver);
		homeObject.selectNoteBoxMenue();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
	


}
