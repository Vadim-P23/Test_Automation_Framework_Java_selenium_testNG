package com.herokuapp.theinternet.pages;

import okhttp3.internal.cache.DiskLruCache;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject{

    private final String pageUrl = "http://the-internet.herokuapp.com/";
    private final By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private final By checkboxesLinkLocator = By.linkText("Checkboxes");
    private final By dropdownLinkLocator = By.linkText("Dropdown");
    private final By javaScriptAlertLocator = By.linkText("JavaScript Alerts");
    private final By multipleWindows = By.linkText("Multiple Windows");
    private final By WYSIWYGEditor = By.linkText("WYSIWYG Editor");

    public WelcomePageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Opening page: ");
    }

    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking Form Authentication link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }

    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking Checkboxes Link on Welcome page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    public DropdownPage clickDropdownLink() {
        log.info("clicking dropdown link on Welcome page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }

    public JavaScriptAlertPage clickJavaScriptAlertLink() {
        log.info("clicking JavaScriptAlertLink link on Welcome page");
        click(javaScriptAlertLocator);
        return new JavaScriptAlertPage(driver, log);
    }

    public MultipleWindowsPage clickMultipleWindowsLink() {
        log.info("clicking clickMultipleWindowsLink link on Welcome page");
        click(multipleWindows);
        return new MultipleWindowsPage(driver, log);
    }

    public EditorPage clickEditorWYSIWYGEditorLink() {
        log.info("clicking clickMultipleWindowsLink link on Welcome page");
        click(WYSIWYGEditor);
        return new EditorPage(driver, log);
    }

}
