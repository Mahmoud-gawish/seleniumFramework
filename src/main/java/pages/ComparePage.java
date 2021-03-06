package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase {

	public ComparePage(WebDriver driver) {
		super(driver);

	}


	@FindBy(css = "a.clear-list")
	WebElement  clearListLink;

	@FindBy(css ="table.compare-products-table")
	WebElement  compareTable;

	@FindBy(css="div.no-data")
	WebElement noDataTable;

	@FindBy(tagName="tr")
	public List<WebElement> allRows;

	@FindBy(tagName="td")
	List<WebElement> allcols;
	
	public void clearCompareTable() {
		clickButton(clearListLink);
	}
	
	public void compareProduct() {
		
		//get  all rows
		System.out.println(allRows.size());
		
		//get data from each row 
		
		for(WebElement row :allRows ) {
			System.out.println(row.getText()+"\t");
			
			
		}
		
		for(WebElement col:allcols) {
			
			System.out.println(col.getText()+"\t");
		}
		
	}

}
