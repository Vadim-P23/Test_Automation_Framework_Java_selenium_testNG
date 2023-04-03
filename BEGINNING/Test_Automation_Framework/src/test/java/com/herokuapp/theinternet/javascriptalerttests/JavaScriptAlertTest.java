package com.herokuapp.theinternet.javascriptalerttests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertTest extends TestUtilities {

    @Test
    public void jsAlertTest() {
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();
        JavaScriptAlertPage alertsPage = welcomePage.clickJavaScriptAlertLink();
        alertsPage.openJSAlert();
        String alertMessage = alertsPage.getAlertText();
        alertsPage.acceptAlert();
        String result = alertsPage.getResultText();
        Assert.assertEquals(alertMessage, "I am a JS Alert", "Alert message is not expected. \n" +
                "Should be I am a JS Alert");
        Assert.assertEquals(result, "You successfully clicked an alert", "Result message is not expected \n" +
                "Should be You successfully clicked an alert");
    }

    @Test
    public void jsAlertConfirmTest() {
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();
        JavaScriptAlertPage alertsPage = welcomePage.clickJavaScriptAlertLink();
        alertsPage.openJSAlertConfirm();
        String alertMessage = alertsPage.getAlertText();
        alertsPage.dismissAlert();
        String result = alertsPage.getResultText();
        Assert.assertEquals(alertMessage, "I am a JS Confirm", "Alert message is not expected. \n" +
                "Should be I am a JS Confirm");
        Assert.assertEquals(result, "You clicked: Cancel", "Result message is not expected \n" +
                "You clicked: Cancel");
    }

    @Test
    public void jsAlertPromptTest() {
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();
        JavaScriptAlertPage alertsPage = welcomePage.clickJavaScriptAlertLink();
        alertsPage.openJSAlertPrompt();
        String alertMessage = alertsPage.getAlertText();
        String testMessage = "test message";
        alertsPage.enterPromptMessage(testMessage);
        String result = alertsPage.getResultText();
        Assert.assertEquals(alertMessage, "I am a JS Prompt", "Alert message is not expected. \n" +
                "Should be I am a JS Prompt");
        Assert.assertEquals(result, "You entered: " + testMessage, "Result message is not expected \n" +
                "You clicked: " + testMessage);
    }




}
