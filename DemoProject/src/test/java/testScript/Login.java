package testScript;

//import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends Base {
	@Test
	public void login() {
		String username="admin";
		String password="admin";
		WebElement usernameField=driver.findElement(By.xpath("//input[@name=\"username\"]"));
		WebElement passwordField=driver.findElement(By.xpath("//input[@name='password']"));
		WebElement buttonField=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		buttonField.click();
		WebElement dashboard=driver.findElement(By.xpath("//p[text()='Dashboard']"));
		boolean ishomepageavailable=dashboard.isDisplayed();
		Assert.assertTrue(ishomepageavailable,"Login Failed");
	}


}


