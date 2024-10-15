package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom.modules.RecommendedAccessoriesModule;
import pom.pages.CartDetailsPage;
import pom.pages.HomePage;
import pom.pages.ProductDetailsPage;
import pom.pages.SearchResultPage;
import pom.pages.SignInPage;

public class VerifySignInPage {

	private WebDriver driver;
	private HomePage homePage;
	private SignInPage signInPage;
	
	@Parameters("browser")
	@BeforeTest
	void launchBrowser(String expectedBrowser) {
		
		System.out.println(expectedBrowser);
		
		if(expectedBrowser.equals("Chrome"))
		{
			driver = new ChromeDriver();	
		}
		
		if(expectedBrowser.equals("Firefox"))
		{
			driver = new FirefoxDriver();	
		}
		
		if(expectedBrowser.equals("Edge"))
		{
			driver = new EdgeDriver();	
		}	
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
	}
	
	@BeforeClass
	void initilizePOM() {
		homePage = new HomePage(driver);
		signInPage  = new SignInPage(driver);
	}
	
	@BeforeMethod
	void loginToAmezon() {
		driver.get("https://www.amazon.in/");
		
		homePage = new HomePage(driver);
		homePage.clickOnLoginButton();
		
	}
	
	@Test (groups = {"snaity", "High", "Regression"})
	void verifySuccessfullLogin() throws InterruptedException {
		signInPage  = new SignInPage(driver);
		signInPage.enterEmailOrPhoneNo("7219751552");
		signInPage.clickOnContinue();
		signInPage.enterPassword("Delta@12345");
		signInPage.clickOnSignIn();
		String actualUserName = homePage.getUserName();
		Assert.assertEquals(actualUserName, "Hello, AkashTest");
		homePage.clickOnLogOutButton();
	}
	
	@Test(groups = {"snaity"})
	void verifyWrongPasswordErrorMessage(){
		signInPage  = new SignInPage(driver);
		signInPage.enterEmailOrPhoneNo("7219751552");
		signInPage.clickOnContinue();
		signInPage.enterPassword("Test@12345");
		signInPage.clickOnSignIn();
		String actualErrorMessage_1 = signInPage.getHeaderErrorMessage();
		String actualErrorMessage_2 = signInPage.getErrorMessage();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualErrorMessage_1, "There was a problem");
		softAssert.assertEquals(actualErrorMessage_2, "Your password is incorrect");
	}
	
	@Test 
	void verifyWrongUserID(){
		signInPage  = new SignInPage(driver);
		signInPage.enterEmailOrPhoneNo("123456");
		signInPage.clickOnContinue();
		String actualErrorMessage_1 = signInPage.getHeaderErrorMessage();
		String actualErrorMessage_2 = signInPage.getErrorMessage();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualErrorMessage_1, "Incorrect phone number");
		softAssert.assertEquals(actualErrorMessage_2, "We cannot find an account with that mobile number");
	}
	
	@AfterClass
	void removePOM() {
		homePage = null  ;
		signInPage  = null;
		System.gc();// garbage Collector 
	}
	
	@AfterTest
	void closedBrowser() {
		driver.quit();
	}
}
