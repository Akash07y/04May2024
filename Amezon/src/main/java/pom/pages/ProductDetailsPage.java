package pom.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {
	
	@FindBy (xpath = "//h1[@id='title']/span")
	private WebElement productName;
	
	@FindBy (xpath = "(//span[@class='a-price-whole'])[5]")
	private WebElement productPrice;
	
	@FindBy (xpath = "(//input[@id='add-to-cart-button'])[2]")
	private WebElement addToCart;
	
	@FindBy (xpath = "//input[@id='buy-now-button']")
	private WebElement buyNow; 
	
	@FindBy (xpath = "//select[@name='quantity']")
	private WebElement quantity; 
	
	@FindBy (xpath = "//input[@id='add-to-wishlist-button-submit']")
	private WebElement addToWishListButton; 
	
	@FindBy (xpath = "(//span[contains(text(),'Shopping List')])[2]")
	private WebElement wishListType; 
	
	
	private WebDriver driver;
	private JavascriptExecutor scriptExecutor ;
	private Actions actions ;
		
	public ProductDetailsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
		this.driver = driver ;
		scriptExecutor = (JavascriptExecutor)this.driver ;
		actions = new Actions(this.driver);
	}

	public String getProductName() {
		return productName.getText().trim();
	}
	
	public int getProductPrice() {
		 return Integer.parseInt(productPrice.getText().replace(",", "").trim());
	}
	
	public void clickOnAddToCard() {
		addToCart.click();
	}
	
	public void clickOnAddToWishList() {
		addToWishListButton.click();
	}
	
	public void SelectWishList() {
		wishListType.click();
	}
	
	public void clickOnBuyNow() {
		buyNow.click();
	}
	
	public void scrollUntillAddToCardButton() {
		scriptExecutor.executeScript("arguments[0].scrollIntoView(true);", addToCart);
		scriptExecutor.executeScript("window.scrollBy(0,-200)");
	}
	
	public void selectQuantity(String noOfQuntity) throws InterruptedException {
		Select select  =  new  Select(quantity);
		select.selectByVisibleText(noOfQuntity);
		actions.click().build().perform();
		
	}
}