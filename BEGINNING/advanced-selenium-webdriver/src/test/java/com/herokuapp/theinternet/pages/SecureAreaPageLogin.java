package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPageLogin extends BasePageObject{

    private By youLoggedIntoSecureArea = By.id("flash");
    private By logout = By.xpath("//a[@class ='button secondary radius']");
    private String expectedUrl = "http://the-internet.herokuapp.com/secure";

    public SecureAreaPageLogin(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return expectedUrl;
    }

    public boolean compareUrlsOnSecureAreaPageLogin() {
      return areUrlsEquals(expectedUrl);
    }

    public boolean isLogOutButtonVisible() {
        return find(logout).isDisplayed();
    }

    public String getSuccessMessageText() {
        return getText(youLoggedIntoSecureArea);
    }


}
