package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPageObjestPage extends PageBase{

	public OrderDetailsPageObjestPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(css="a.button-2.print-order-button")
	WebElement printInvoiceLink;
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[1]/a[2]")
	WebElement pdfInvoiceLink;
	
	public void printOrderDetails() {
		
		clickButton(printInvoiceLink);
	
	}
	
	public void downloadPdfInvoice() {
		
		clickButton(pdfInvoiceLink);
	}
	
	
	

}
