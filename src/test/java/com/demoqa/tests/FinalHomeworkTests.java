package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.WindowsPage;
import com.demoqa.pages.FramesPage;
import com.demoqa.pages.SelectPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FinalHomeworkTests extends TestBase {

    @Test
    @DisplayName("Проверка вложенных фреймов")
    public void nestedFramesTest() {
        driver.get("https://demoqa.com/nestedframes");
        FramesPage framesPage = new FramesPage(driver);

        String parentText = framesPage.getParentFrameText();
        assertTrue(parentText.toLowerCase().contains("parent frame"));

        String childText = framesPage.getChildFrameText();
        assertTrue(childText.toLowerCase().contains("child iframe"));

        framesPage.exitToMainContent();
    }

    @Test
    @DisplayName("Проверка выпадающего списка (Select)")
    public void selectMenuTest() {
        driver.get("https://demoqa.com/select-menu");
        SelectPage selectPage = new SelectPage(driver);

        selectPage.selectColorByText("Aqua");
        assertEquals("Aqua", selectPage.getSelectedColorText());
    }

    @Test
    @DisplayName("Проверка открытия новой вкладки")
    public void windowTabTest() {
        driver.get("https://demoqa.com/browser-windows");
        WindowsPage windowsPage = new WindowsPage(driver);

        windowsPage.clickOnClickHere();
        windowsPage.switchToTab(1);

        assertTrue(windowsPage.getSampleText().contains("sample"));

        driver.close();
        windowsPage.switchToTab(0);
    }
}
