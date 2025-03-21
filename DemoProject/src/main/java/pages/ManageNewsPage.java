package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtilities;

public class ManageNewsPage {

	WebDriver driver;

	public ManageNewsPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")private WebElement infoButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")private WebElement addNewsButton;
	@FindBy(xpath="//textarea[@id='news']") private WebElement newNewsTextArea;
	@FindBy(xpath="//button[@name='create']")private WebElement newsSaveButton;
	@FindBy(xpath="//i[@class=\"icon fas fa-check\"]")private WebElement alertSuccess;
	
	public void clickMoreInfo() {
		infoButton.click();
	}

	public void addNews() {
		addNewsButton.click();
	}

	public void enterNews(String newnews) {
		WaitUtilities waitutilities = new WaitUtilities();
		waitutilities.waitForElementToBeClickable(driver, newNewsTextArea);
		newNewsTextArea.sendKeys(newnews);
	}

	public void saveNews() {
		newsSaveButton.click();
	}

	public boolean isSuccessAlertDisplayed() {
		return alertSuccess.isDisplayed();
	}

}