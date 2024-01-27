package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage extends BasePageObject{

    public FileUploaderPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    private final String pageUrl = "https://the-internet.herokuapp.com/upload";
    private final By chooseFile = By.id("file-upload");
    private final By upload = By.id("file-submit");
    private final By uploadedFiles = By.id("uploaded-files");

    public void openPage() {
        log.info("Opening page " + pageUrl);
        openUrl(pageUrl);
    }

    public void pushUploadButton() {
        click(upload);
    }

    public void selectFiles(String fileName) {
        String filePath = System.getProperty("user.dir") + "//src//main//resources//files//" + fileName;
        type(filePath, chooseFile);
    }

    public  String getUploadedFilesNames() {
        return getText(uploadedFiles);
    }

}
