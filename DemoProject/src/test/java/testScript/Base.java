package testScript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;
import utilities.WaitUtilities;

public class Base {
	
	public WebDriver driver;
	public ScreenshotUtility scrshot;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializebrowser(String browser) throws Exception{
		
		if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver(); 
		}
		else if(browser.equalsIgnoreCase("edge")){
			driver = new EdgeDriver(); 

		}
		else if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver(); 

		}
		else {
			throw new Exception("Driver is not available");
			}
		driver.get("https://groceryapp.uniqassosiates.com/admin"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtilities.IMPLICIT_WAIT));
		driver.manage().window().maximize(); 
		
	}
	@AfterMethod(alwaysRun=true)
	public void browserQuit(ITestResult iTestResult) throws IOException { 
 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
 			scrshot = new ScreenshotUtility(); 
 			scrshot.getScreenShot(driver, iTestResult.getName()); 
 		} 
  
 		// driver.quit(); 
 	}
	
	

}
