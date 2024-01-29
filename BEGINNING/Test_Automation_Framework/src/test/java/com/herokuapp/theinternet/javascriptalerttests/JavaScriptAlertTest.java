package com.herokuapp.theinternet.javascriptalerttests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaScriptAlertTest extends TestUtilities {

    @Test
    public void jsAlertTest() {
        log.info("Starting jsAlertTest");

        SoftAssert softAssert = new SoftAssert();

        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        JavaScriptAlertPage alertsPage = welcomePage.clickJavaScriptAlertLink();
        alertsPage.openJSAlert();
        String alertMessage = alertsPage.getAlertText();
        alertsPage.acceptAlert();
        String result = alertsPage.getResultText();
        softAssert.assertEquals(alertMessage, "I am a JS Alert", "Alert message is not expected. \n" +
                "Should be I am a JS Alert");
        softAssert.assertEquals(result, "You successfully clicked an alert", "Result message is not expected \n" +
                "Should be You successfully clicked an alert");
        softAssert.assertAll();
    }

    @Test
    public void jsAlertConfirmTest() {
        log.info("Starting jsAlertConfirmTest");
        SoftAssert softAssert = new SoftAssert();
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        JavaScriptAlertPage alertsPage = welcomePage.clickJavaScriptAlertLink();
        alertsPage.openJSAlertConfirm();
        String alertMessage = alertsPage.getAlertText();
        alertsPage.dismissAlert();
        String result = alertsPage.getResultText();
        softAssert.assertEquals(alertMessage, "I am a JS Confirm", "Alert message is not expected. \n" +
                "Should be I am a JS Confirm");
        softAssert.assertEquals(result, "You clicked: Cancel", "Result message is not expected \n" +
                "You clicked: Cancel");
        softAssert.assertAll();
    }

    @Test
    public void jsAlertPromptTest() {
        log.info("Starting jsAlertPromptTest");
        SoftAssert softAssert = new SoftAssert();
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        JavaScriptAlertPage alertsPage = welcomePage.clickJavaScriptAlertLink();
        alertsPage.openJSAlertPrompt();
        String alertMessage = alertsPage.getAlertText() + "[FAIL]";
        String testMessage = "test message";
        alertsPage.enterPromptMessage(testMessage);
        alertsPage.acceptAlert();
        String result = alertsPage.getResultText() + "[FAIL]";
        softAssert.assertEquals(alertMessage, "I am a JS prompt", "Alert message is not expected. \n" +
                "Should be I am a JS prompt");
        softAssert.assertEquals(result, "You entered: " + testMessage, "Result message is not expected \n" +
                "You clicked: " + testMessage);
        softAssert.assertAll();
    }




}
