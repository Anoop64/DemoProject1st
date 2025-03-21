package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	
	public void selectByValue(WebElement element,String value) {
		Select select =new Select(element);
		select.selectByValue(value);
	}
	public void selectByindex(WebElement element,int Index) {
		Select select =new Select(element);
		select.selectByIndex(Index);
	}
	public void selectByVisibleText(WebElement element,String Text) {
		Select select =new Select(element);
		select.selectByVisibleText(Text);
	}
}
