package com.herokuapp.theinternet.windowstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.MultipleWindowsPage;
import com.herokuapp.theinternet.pages.NewWindowsPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTests extends TestUtilities {

    @Test
    public void newWindowTest() {
        log.info("Starting newWindowTest");
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();
        MultipleWindowsPage windowsPage = welcomePage.clickMultipleWindowsLink();
        windowsPage.openNewWindow();
        String expectedTitle = "New Window";
        windowsPage.switchToWindowWithTitle(expectedTitle);
        String currentTitle = welcomePage.getCurrentPageTitle();
        Assert.assertEquals(currentTitle, expectedTitle);
    }


}
