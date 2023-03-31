package com.herokuapp.theinternet.dropdowntests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends TestUtilities {

    @Test
    public void optionTwoTest() {
        log.info("Starting optionTwoTest");

        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

        dropdownPage.selectOption(2);

        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertEquals(selectedOption, "Option 2", "Option 2 is not selected. Instead selected - " + selectedOption);
    }
}