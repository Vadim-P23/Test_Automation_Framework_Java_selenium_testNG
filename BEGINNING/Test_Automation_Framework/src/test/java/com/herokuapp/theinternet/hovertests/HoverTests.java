package com.herokuapp.theinternet.hovertests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTests  extends TestUtilities {

    @Test
    public void usersProfileTest() {
        log.info("Starting user profile test");
        WelcomePage welcomePage = new WelcomePage(driver, log );
        welcomePage.openPage();
        HoversPage hoverPage = new HoversPage(driver, log );
        hoverPage.openHoversPage();
        hoverPage.openUserProfile(3);
        log.info("Current Url is " +  driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/users/3");
    }
}
