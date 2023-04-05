package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends BasePageObject {

    public MultipleWindowsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    private By clickHere = By.xpath("//a[.='Click Here']");
    private By openingNewWindow = By.xpath("//h3");

    public void openNewWindow() {
        log.info("Clicking Click Here link");
        click(clickHere);
    }

    public NewWindowsPage clickMultipleWindowsLink() {
        log.info("Looking for new window page");
        switchToWindowWithTitle("New Window");
        return new NewWindowsPage(driver, log);
    }



}
