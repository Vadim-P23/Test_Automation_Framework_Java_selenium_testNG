package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage extends BasePageObject {

    public JavaScriptAlertPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    private Alert alert;

    private By clickForJSAlert = By.xpath("//button[.='Click for JS Alert']");
    private By clickForJSConfirm = By.xpath("//button[.='Click for JS Confirm']");
    private By clickForJSPrompt = By.xpath("//button[.='Click for JS Prompt']");
    private By resultMessage = By.id("result");

    public void openJSAlert() {
        log.info("Clicking on Click for JS Alert button to open alert");
        click(clickForJSAlert);
    }

    public void openJSAlertConfirm() {
        log.info("Clicking on Click for JS Confirm button to open alert");
        click(clickForJSConfirm);
    }
    public void openJSAlertPrompt() {
        log.info("Clicking on Click for JS Prompt button to open alert");
        click(clickForJSPrompt);
    }

    public String getAlertText() {
        alert = switchToAlert();
        String alertText = alert.getText();
        log.info("Alert says: " + alertText);
        return alertText;
    }

    public void acceptAlert() {
        alert.accept();
    }

    public void dismissAlert() {
        alert.dismiss();
    }

    public void enterPromptMessage(String message) {
        alert.sendKeys(message);
    }

    public String getResultText() {
        String result = find(resultMessage).getText();
        log.info("Result text: " + result);
        return result;
    }

}
