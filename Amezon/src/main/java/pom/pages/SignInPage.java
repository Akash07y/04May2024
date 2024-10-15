package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	@FindBy (xpath = "//input[@id='ap_email']")
	private WebElement emailOrPhoneNo;
	
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement continueButton;
		
	@FindBy (xpath = "//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy (xpath = "//input[@id='signInSubmit']")
	private WebElement signIn;
	
	@FindBy (xpath = "//div[@id='auth-error-message-box']//h4")
	private WebElement errorMessageHeader;
	
	@FindBy (xpath = "//div[@id='auth-error-message-box']//span")
	private WebElement errorMessage;
	
	public SignInPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void enterEmailOrPhoneNo(String userId) {
		emailOrPhoneNo.sendKeys(userId);
	}

	public void enterPassword(String userPassword) {
		password.sendKeys(userPassword);
	}

	public void clickOnContinue() {
		continueButton.click();
	}
	
	public void clickOnSignIn() {
		signIn.click();
	}
	
	public String getHeaderErrorMessage() {
		return errorMessageHeader.getText().trim();
	}

	public String getErrorMessage() {
		return errorMessage.getText().trim();
	}
}


