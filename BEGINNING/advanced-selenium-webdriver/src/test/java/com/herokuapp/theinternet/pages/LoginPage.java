package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.tagName("button");
    private By yourUsernameIsInvalid = By.id("flash");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public SecureAreaPageLogin logIn(String username, String password) {
        log.info("Executing Login with username ["+ username +"] and password ["+ password +"]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(loginButtonLocator);
        return new SecureAreaPageLogin(driver, log);
    }

    public void negativelogIn(String username, String password) {
        log.info("Executing Negative Login with username ["+ username +"] and password ["+ password +"]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(loginButtonLocator);
    }

    public String getErrorMessageText() {
        return getText(yourUsernameIsInvalid);
    }

}
