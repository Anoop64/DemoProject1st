package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;

public class AdminUsersPage {

	WebDriver driver;

	public AdminUsersPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")private WebElement clickOnMoreInfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement clickOnNew;
	@FindBy(xpath="//input[@id='username']") private WebElement fillUserName;
	@FindBy(xpath="//input[@id='password']")private WebElement fillPassword;
	@FindBy(xpath="//select[@id='user_type']")private WebElement selectDropdown;
	@FindBy(xpath="//button[@name='Create']")private WebElement clickOnSave;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")private WebElement clickOnDelete;


	
	public void clickMoreInfo() {
		clickOnMoreInfo.click();
	}

	public void clickNew() {
		clickOnNew.click();
	}

	public void enterUsername(String Anoop) {
		fillUserName.sendKeys(Anoop);
	}
	public void enterPassword(String anoop) {
		fillPassword.sendKeys(anoop);
	}
	public void selectDropdown() {
		//Select select = new Select(selectDropdown);
		//select.selectByIndex(3);
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.selectByindex(selectDropdown, 3);
		
	}
	

	public void save() {
		clickOnSave.click();
	}
	public void Delete() {
		clickOnDelete.click();
		driver.switchTo().alert().accept();
	}
	

	

}
