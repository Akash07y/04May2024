package pom.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CartDetailsPage {
	
	@FindBy (xpath = "(//div[@data-item-index='1'])[1]//h4//span[@class='a-truncate-cut']")
	private WebElement firstProductName;
	
	@FindBy (xpath = "((//div[@data-item-index='1'])[1]//div[@class='sc-item-price-block']//div/span)")
	private List<WebElement> productPrice;
	
	@FindBy (xpath = "(//div[@data-item-index='1'])[1]//input[@value='Delete']")
	private WebElement delete;	
	
	@FindBy (xpath = "(//div[@data-item-index='1'])[1]//select[@name='quantity']")
	private WebElement quantity;	
	
	public CartDetailsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	
	public String getFirstProductName() {
		String name =  firstProductName.getText().trim();
		System.out.println("Cart Page ProductName- " + name);
		return name;
	}
	
	public int getFirstProductPrice() {	
		if (productPrice.size() > 1 ) 
			return (int) Double.parseDouble(productPrice.get(2).getText().replace(",", "").trim());
		else
			return (int) Double.parseDouble(productPrice.get(0).getText().replace(",", "").trim());
	}
	
	public void deleteProductFromCart() {
		delete.click();
	}
	
	public String getQuantity() {
		Select select = new Select(quantity);
		return select.getFirstSelectedOption().getText().trim();
	}
}
