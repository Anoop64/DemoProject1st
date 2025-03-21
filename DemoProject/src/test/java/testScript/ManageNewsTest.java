package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExelUtilities;

public class ManageNewsTest extends Base {

	@Test
	public void selectManageNews() throws IOException {

		
		//String username = "admin"; 
		//String password = "admin";
		//String newnews = "TODAY IS 07 MARCH 2025";
		
		String username=ExelUtilities.getStringData(1,0,"loginpage");
		String password=ExelUtilities.getStringData(1,1,"loginpage");
		String newnews=ExelUtilities.getStringData(6,0,"loginpage");


		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
		
		
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		managenewspage.clickMoreInfo();
		managenewspage.addNews();
		managenewspage.enterNews(newnews);
		managenewspage.saveNews();

		
		boolean successModalDisplayed = managenewspage.isSuccessAlertDisplayed();
		Assert.assertTrue(successModalDisplayed,"NOT SUCCESS");
	}
}