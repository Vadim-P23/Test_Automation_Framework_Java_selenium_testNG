package com.herokuapp.theinternet.draganddroptests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;

import org.testng.annotations.Test;

public class DragAndDropTests extends TestUtilities {
    @Test
    public void dragAtoBtest() {
        log.info("Starting dragAtoBtest");
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver, log);
    }

}
