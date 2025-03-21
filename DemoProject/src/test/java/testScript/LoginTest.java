package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExelUtilities;

public class LoginTest extends Base { 			// Page Object Model POM // Design Pattern
	@Test(groups={"Regression"},retryAnalyzer=retry.Retry.class,description="With Valid Credentials")
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {
		
		//String username="admin";
		//String password="admin";
		
		String username=ExelUtilities.getStringData(1,0,"loginpage");
		String password=ExelUtilities.getStringData(1,1,"loginpage");

		LoginPage loginpage = new LoginPage(driver); // Object creation
		
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
		boolean isloaded = loginpage.isDashBoardLoaded();
		Assert.assertTrue(isloaded, "Home Page not loaded, when correct credentials are entered");
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidPassword() throws IOException {
		//String username="admin";
		//String password="wrongpassword";
		String username=ExelUtilities.getStringData(2,0,"loginpage");
		String password=ExelUtilities.getStringData(2,1,"loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
		boolean checkalert = loginpage.isAlertDisplayedForWrongPassword();
		Assert.assertTrue(checkalert, "Login failed, Wrong Username or Password");
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsername() throws IOException {
		//String username="wrongusername";
		//String password="admin";
		
		String username=ExelUtilities.getStringData(3,0,"loginpage");
		String password=ExelUtilities.getStringData(3,1,"loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
		boolean checkusername = loginpage.isAlertDisplayedForWrongUsername();
		Assert.assertTrue(checkusername, "Login failed, Wrong Username or Password");
	}
	@Test
	public void verifyTheUserIsAbleToLoginUsingInvalidUsernameAndInvalidPassword() throws IOException {
		//String username="wrongusername";
		//String password="wrongpassword";
		
		String username=ExelUtilities.getStringData(4,0,"loginpage");
		String password=ExelUtilities.getStringData(4,1,"loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
		boolean checkusernameandpassword = loginpage.isAlertDisplayedForWrongUsernameAndWrongPassword();
		Assert.assertTrue(checkusernameandpassword, "Login failed, Wrong Username or Password");
	}
}
