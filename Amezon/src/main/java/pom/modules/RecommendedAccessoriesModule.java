package pom.modules;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecommendedAccessoriesModule {

	@FindBy (xpath = "//span[@id='attach-sidesheet-view-cart-button']//input")
	private WebElement cartButton;
	
	private WebDriver driver ;
	WebDriverWait wait ;
	
	public RecommendedAccessoriesModule(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	public void goToCartPage() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(cartButton));
		cartButton.click();
	}
}