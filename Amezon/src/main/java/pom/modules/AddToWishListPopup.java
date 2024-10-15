package pom.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToWishListPopup {
	
	@FindBy (xpath = "//a[text()='View Your List']")
	private WebElement viewWishListButton;
	
	@FindBy (xpath = "//a[@id='huc-item-link']/span")
	private WebElement productName;
	
	private WebDriver driver ;
	
	public AddToWishListPopup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnViewWishList() {
		viewWishListButton.click();
	}
	
	public String getProductNameOnPopup() {
		return productName.getText().trim();
	}
}
