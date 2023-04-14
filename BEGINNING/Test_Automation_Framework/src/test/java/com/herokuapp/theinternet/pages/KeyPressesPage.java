package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePageObject {

    public KeyPressesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    private final String keyPassesUrl = "https://the-internet.herokuapp.com/key_presses?";
    private final By body = By.xpath("//body");
    private final By resultTextLocator = By.id("result") ;

    public void openPage() {
        openUrl(keyPassesUrl);
    }

    public void pressKey(Keys key) {
        log.info("Pressing " + key.name());
        pressKey(body, key);
    }

    public String getResultText() {
        return getText(resultTextLocator);
    }
}
