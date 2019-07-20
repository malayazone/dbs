package stepDefinitions;

import org.testng.Assert;

import com.cucumber.listener.Reporter;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class GoogleSearchSteps extends DriverFactory {

	@Given("^that I have gone to the Google page$")
	public void that_I_have_gone_to_the_Google_page() throws Throwable {
		Reporter.addStepLog("Navigate to www.google.com");
		googleSearchPage.openGoogleSearchPage();
	    throw new PendingException();
	}

	@When("^I add \"([^\"]*)\" to the search box$")
	public void i_add_to_the_search_box(String textToSearch) throws Throwable {
		Reporter.addStepLog("Searching " + textToSearch);
		googleSearchPage.enterTextInSearchBox(textToSearch);
	    throw new PendingException();
	}

	@When("^click the Search Button$")
	public void click_the_Search_Button() throws Throwable {
	    googleSearchPage.clickSearchButton();
	    throw new PendingException();
	}

	@Then("^\"([^\"]*)\" should be mentioned in the results$")
	public void should_be_mentioned_in_the_results(String textToverify) throws Throwable {
	    String[] allWebLinks = googleSearchPage.getAllWebLinkText();
	    for (int i = 0; i < allWebLinks.length; i++) {
	    	Assert.assertTrue(allWebLinks[i].contains(textToverify));
	    }
	    throw new PendingException();
	}

}
