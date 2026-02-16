package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.FramesPage;
import com.demoqa.pages.SelectPage;
import com.demoqa.pages.WindowsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinalHomeworkTests extends TestBase {

    @Test
    public void nestedFramesTest() {
        driver.get("https://demoqa.com/nestedframes");
        FramesPage framesPage = new FramesPage(driver);
        String text = framesPage.getParentFrameText();
        Assertions.assertEquals("Parent frame", text);
    }

    @Test
    public void windowTabTest() {
        driver.get("https://demoqa.com/browser-windows");
        WindowsPage windowsPage = new WindowsPage(driver);
        windowsPage.clickOnClickHere();
        windowsPage.switchToNewWindow(1);
        String text = windowsPage.getHeaderText();
        Assertions.assertEquals("This is a sample page", text);
    }

    @Test
    public void selectMenuTest() {
        driver.get("https://demoqa.com/select-menu");
        SelectPage selectPage = new SelectPage(driver);
        selectPage.selectColorByText("Blue");
        Assertions.assertEquals("Blue", selectPage.getSelectedValue());
    }
}