package com.herokuapp.theinternet.keypressestests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTests extends TestUtilities {

    @Test
    public void keyPressesTest() {
        KeyPressesPage keyPressesPage = new KeyPressesPage(driver, log);
        keyPressesPage.openPage();
        keyPressesPage.pressKey(Keys.ENTER);
        String result = keyPressesPage.getResultText();
        Assert.assertEquals(result, "You entered: ENTER");
    }

    @Test
    public void pressKeyWithActionsTest() {
        KeyPressesPage keyPressesPage = new KeyPressesPage(driver, log);
        keyPressesPage.openPage();
        keyPressesPage.pressKey(Keys.SPACE);
        String result = keyPressesPage.getResultText();
        Assert.assertEquals(result, "You entered: SPACE");
    }


}
