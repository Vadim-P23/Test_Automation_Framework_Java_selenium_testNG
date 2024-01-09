package com.herokuapp.theinternet.draganddroptests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestUtilities {

    @Test
    public void dragAtoBtest() {
        log.info("Starting dragAtoBtest");

        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver, log);
        dragAndDropPage.openPage();
        dragAndDropPage.dragAtoB();

        // Verify correct headers in correct boxes
        String columnAText = dragAndDropPage.getColumnAText();
        Assert.assertEquals(columnAText, "B", "Column A Header should be B");
        String columnBText = dragAndDropPage.getColumnBText();
        Assert.assertEquals(columnBText, "A", "Column B Header should be A");

    }

}
