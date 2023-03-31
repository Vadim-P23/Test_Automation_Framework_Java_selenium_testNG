package com.herokuapp.theinternet.loginpagetest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPageLogin;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void logInTest() {
		log.info("Starting logIn test");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		log.info("Main page is opened.");

		// Click on Form Authentication link
		LoginPage loginpage = welcomePage.clickFormAuthenticationLink();
		// execute login
		SecureAreaPageLogin secureAreaPageLogin = loginpage.logIn("tomsmith", "SuperSecretPassword!");

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
