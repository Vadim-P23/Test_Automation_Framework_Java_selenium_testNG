package com.herokuapp.theinternet.editortests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorsTests extends TestUtilities {

    @Test
    public void defaultEditorValueTest() {
        log.info("Starting defaultEditorValueTest");
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        //welcomePage.scrollToBottom();
        EditorPage editorPage = welcomePage.clickEditorWYSIWYGEditorLink();
        //editorPage.switchToFrame(editorPage.iframe);

        String editorText = editorPage.getEditorText();
        Assert.assertEquals("Your content goes here.", editorText);
    }

}
