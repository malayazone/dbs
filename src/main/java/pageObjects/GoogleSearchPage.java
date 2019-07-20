package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage extends BasePage {
	public @FindBy(xpath = "//input[@name='q']/preceding-sibling::div") WebElement googleSearchTextBox;
	public @FindBy(xpath = "//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']") WebElement googleSearchButton;
	public @FindBy(xpath = "//h1[text()='Search Results']/following-sibling::div//a/h3") WebElement allSearchedWebLinks;

	public GoogleSearchPage() throws IOException {
	super();
	}
	
	public GoogleSearchPage openGoogleSearchPage() throws IOException {
		getDriver().get("http://www.google.com");
		return this;
	}
	
	public GoogleSearchPage enterTextInSearchBox(String text) throws Exception {
		googleSearchTextBox.click();
		sendKeysToWebElement(googleSearchTextBox, text);
		return this;
	}
	
	public GoogleSearchPage clickSearchButton() throws Exception {
		waitAndClickElement(googleSearchTextBox);
		waitForPageToLoad();
		return this;
	}
	
	public String[] getAllWebLinkText() throws Exception {
	List<WebElement> webLinks = driver.findElements(By.xpath("//h1[text()='Search Results']/following-sibling::div//a/h3"));
	String[] webLinksArray = new String[webLinks.size()];
	for(int i = 0; i < webLinks.size(); i++) {
		webLinksArray[i] = webLinks.get(i).getText();
	}
	return webLinksArray;
	}

}
