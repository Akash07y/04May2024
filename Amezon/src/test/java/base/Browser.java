package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
            // BaseClass / Base / Pojo / Browser
public class Browser {

	public static WebDriver launchChromeBrowser() {		
		//System.setProperty("webDriver.chrome.driver", "driver exec file path");
		WebDriver driver = new ChromeDriver();	
		return driver ;
	}
	
	public static WebDriver launchFirefoxBrowser() {		
		//System.setProperty("webDriver.edge.driver", "driver exec file path");
		WebDriver driver = new FirefoxDriver();	
		return driver ;
	}
	
	public static WebDriver launchEdgeBrowser() {		
		//System.setProperty("webDriver.edge.driver", "driver exec file path");
		WebDriver driver = new EdgeDriver();	
		return driver ;
	}
	
	public static WebDriver launchBrowser(String targetBrowser ) {
		WebDriver driver = null;
		if(targetBrowser.equals("Chrome"))
		{
			driver = launchChromeBrowser();               			
		}
			
		if(targetBrowser.equals("Firefox"))
		{
			driver = launchFirefoxBrowser();	
		}
		
		if(targetBrowser.equals("Edge"))
		{
			driver = launchEdgeBrowser();
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		return driver ;
	}

}
