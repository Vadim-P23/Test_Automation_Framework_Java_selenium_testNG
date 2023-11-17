package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DragAndDropPage extends BasePageObject {

    private String pageUrl = "https://the-internet.herokuapp.com/drag_and_drop";

    private By column_a = By.id("column-a");
    private By column_b = By.id("column-b");

    public DragAndDropPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openPage() {
        log.info("Open drag and drop page");
        openUrl(pageUrl);
        log.info("Drag and drop page was opened!");
    }

    public void dragAtoB() {
        log.info("Drag and drop A box on b box");
        performDragAndDrop(column_a, column_b);
    }
    /** Getting Column A Text */
    public String getColumnAText() {
        String text = find(column_a).getText();
        log.info("Column A Text: " + text);
        return text;
    }

    /** Getting Column B Text */
    public String getColumnBText() {
        String text = find(column_b).getText();
        log.info("Column B Text: " + text);
        return text;
    }



}
