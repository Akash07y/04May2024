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

import base.Browser;
import pom.modules.AddToWishListPopup;
import pom.modules.RecommendedAccessoriesModule;
import pom.pages.CartDetailsPage;
import pom.pages.HomePage;
import pom.pages.ProductDetailsPage;
import pom.pages.SearchResultPage;
import pom.pages.SignInPage;
import pom.pages.YourListPage;
import utils.Utility;

public class ValidateCartAndBuy extends Browser{

	private WebDriver driver;
	private HomePage homePage;
	private SignInPage signInPage;
	private SearchResultPage searchResultPage;
	private ProductDetailsPage productDetailsPage;
	private RecommendedAccessoriesModule recommendedAccessoriesModule ;
	private CartDetailsPage cartDetailsPage ;
	private AddToWishListPopup addToWishListPopup;
	private YourListPage yourListPage;
	private List<String> browserAddress ;
	
	private  String testID ;
	
	@Parameters("browser")
	@BeforeTest
	void openBrowser(String expectedBrowser ) {
		
		System.out.println(expectedBrowser);		
		driver = launchBrowser(expectedBrowser);
		
	}
	
	@BeforeClass
	void initilizePOM() {
		homePage = new HomePage(driver);
		signInPage  = new SignInPage(driver);
		searchResultPage = new SearchResultPage(driver);
		productDetailsPage = new ProductDetailsPage(driver);
		recommendedAccessoriesModule = new RecommendedAccessoriesModule(driver);
		cartDetailsPage = new CartDetailsPage(driver);
		addToWishListPopup  = new AddToWishListPopup(driver);
		yourListPage = new YourListPage(driver);
	}
	
	@BeforeMethod
	void loginToAmezon() {
		driver.get("https://www.amazon.in/");
		homePage.clickOnLoginButton();		
		//signInPage.enterEmailOrPhoneNo("7219751552");
	//	signInPage.enterEmailOrPhoneNo(Utility.getDataFromExcel());
		signInPage.clickOnContinue();
	//	signInPage.enterPassword(Utility.getDataFromExcel());
		signInPage.clickOnSignIn();
	}
	
	@Test   //(enabled = false)
	void verifyAddToCard() throws InterruptedException {
		testID = "T1011"  ;

	}
	
	@AfterMethod
	void logoutFromAmezon() {
		driver.close();
		driver.switchTo().window(browserAddress.get(0));
		homePage.clickOnLogOutButton();
		
		Utility.captureScreeshot();// use testId here
	}
	
	@AfterClass
	void removePOM() {
		homePage = null  ;
		signInPage  = null;
		searchResultPage = null;
		productDetailsPage = null;
		recommendedAccessoriesModule = null;
		cartDetailsPage = null;
		System.gc();// garbage Collector 
	}
	
	@AfterTest
	void closedBrowser() {
		driver.quit();
	}
}
