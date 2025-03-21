package testScript;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.FakerUtilities;

public class AdminUsersTest extends Base {

	@Test
	public void selectAdminUsersInformation() {

		String username = "admin";
		String password = "admin";	
		
		FakerUtilities faker = new FakerUtilities();
		String usernameinsert=faker.creatARandomFirstName();
		String passwordinsert=faker.creatARandomLastName();

		// String usernameinsert ="anoop";
		// String passwordinsert ="anoop";

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.signIn();

		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickMoreInfo();
		adminuserspage.clickNew();

		
		adminuserspage.enterUsername(usernameinsert);
		adminuserspage.enterPassword(passwordinsert);
		adminuserspage.selectDropdown();
		adminuserspage.save();
		//adminuserspage.Delete();

	}
}