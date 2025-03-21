package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) { // Constructor created WRTo LoginTest line 15
		this.driver=driver;
		PageFactory.initElements(driver, this);  // pageFactory is a class & initElements is method
	}
	@FindBy(xpath="//input[@name=\"username\"]")private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type=\"submit\"]")private WebElement buttonField;
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboard;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alert;
	
	

	public void enterUserName(String username) {
		usernameField.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	public void signIn() {
		buttonField.click();
	}
	public boolean isDashBoardLoaded() {
		return dashboard.isDisplayed();
	}
	public boolean isAlertDisplayedForWrongPassword() {
		return alert.isDisplayed();
	}
	public boolean isAlertDisplayedForWrongUsername() {
		return alert.isDisplayed();
	}
	public boolean isAlertDisplayedForWrongUsernameAndWrongPassword() {
		return alert.isDisplayed();
		}
}
