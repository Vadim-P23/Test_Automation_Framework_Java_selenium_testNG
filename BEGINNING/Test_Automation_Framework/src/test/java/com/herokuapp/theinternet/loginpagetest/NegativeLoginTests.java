package com.herokuapp.theinternet.loginpagetest;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLoginTests extends TestUtilities {


	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void negativeLoginTest( Map<String, String> testData) {
		//Data
		String no = testData.get("no");
		String username = testData.get("username");
		String password = testData.get("password");
		String expectedMessage = testData.get("expectedMessage");
		String description = testData.get("description");

		log.info("Starting negativeLoginTest #" + no + " for " + description);

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		log.info("Main page is opened.");

		// Click on Form Authentication link
		LoginPage loginpage = welcomePage.clickFormAuthenticationLink();

		// enter username and password
		loginpage.negativelogIn(username, password);

		// Verification
		String actualErrorMessage = loginpage.getErrorMessageText();
		Assert.assertTrue(actualErrorMessage.contains(expectedMessage),
				"Message does not contain expected text");
	}

}
