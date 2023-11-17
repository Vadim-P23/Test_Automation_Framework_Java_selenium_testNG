package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage extends BasePageObject{

    public EditorPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    private final By iframe = By.xpath("//iframe");
    private final By editorLocator = By.id("tinymce");

    public void switchToEditorFrame() {

    }

    public String getEditorText() {
        String text = find(editorLocator).getText();
        return text;
    }



}
