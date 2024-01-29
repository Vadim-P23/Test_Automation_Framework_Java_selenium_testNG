package com.herokuapp.theinternet.loginpagetest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPageLogin;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void logInTest() {
		log.info("Starting logIn test");

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		takeScreenshot("loginPage opened");
		log.info("Main page is opened.");

		// Click on Form Authentication link
		LoginPage loginpage = welcomePage.clickFormAuthenticationLink();
		// execute login
		SecureAreaPageLogin secureAreaPageLogin = loginpage.logIn("tomsmith", "SuperSecretPassword!");
		takeScreenshot("SecureAreaPage opened");
		// verifications
		// new pageurl is expected url
		Assert.assertEquals(secureAreaPageLogin.getCurrentUrl(), secureAreaPageLogin.getPageUrl());
		// log out button is visible
		Assert.assertTrue(secureAreaPageLogin.isLogOutButtonVisible(),
				"logOutButton is not visible.");
		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPageLogin.getSuccessMessageText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
}
