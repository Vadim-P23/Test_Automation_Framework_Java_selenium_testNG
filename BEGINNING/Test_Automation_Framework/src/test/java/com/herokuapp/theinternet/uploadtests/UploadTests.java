package com.herokuapp.theinternet.uploadtests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends TestUtilities {

    @Test(dataProvider = "files")
    public void filesUploadTest(int no, String fileName) {
        log.info("Starting fileUploadTest #" + no + " for " + fileName);

        FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, log);
        fileUploaderPage.openPage();

        fileUploaderPage.selectFiles(fileName);

        fileUploaderPage.pushUploadButton();

        String fileNames = fileUploaderPage.getUploadedFilesNames();

        Assert.assertTrue(fileNames.contains(fileName));
    }



}
