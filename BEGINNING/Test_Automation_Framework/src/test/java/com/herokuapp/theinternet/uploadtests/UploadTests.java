package com.herokuapp.theinternet.uploadtests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends TestUtilities {

    @Test(dataProvider = "files")
    public void imageUploadTest() {
        log.info("Starting imageUploadTest");
        FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, log);
        fileUploaderPage.openPage();
        String expectedFileName = "text.txt";
        fileUploaderPage.selectingFiles(expectedFileName);
        fileUploaderPage.pushUploadButton();
        String actualFileName = fileUploaderPage.getUploadedFilesNames();
        Assert.assertEquals(actualFileName, expectedFileName, "Failed! Files names don't match");
    }



}
