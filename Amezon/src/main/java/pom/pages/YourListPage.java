package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourListPage {
	
	@FindBy (xpath = "//a[contains(@id,'itemName')]")
	private WebElement productName;
	
	@FindBy (xpath = "//input[@name='submit.deleteItem']")
	private WebElement deleteButton;
	
	
	public YourListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getProductNameFromWishList() {
		System.out.println("tester branch");
		return productName.getText().trim();
		
	}
	
	public void deleteProductFromList() {
		deleteButton.click();
	}
}
