package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.NestedFramesPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NestedFramesTests extends TestBase {

    @Test
    public void testNestedFrames() {
        driver.get("https://demoqa.com/nestedframes");
        NestedFramesPage nestedFramesPage = new NestedFramesPage(driver);


        String parentText = nestedFramesPage.getParentFrameText();
        assertTrue(parentText.toLowerCase().contains("parent frame"), "Текст родителя не найден!");


        String childText = nestedFramesPage.getChildFrameText();
        assertTrue(childText.toLowerCase().contains("child iframe"), "Текст ребенка не найден!");


        nestedFramesPage.switchToDefaultContent();
    }
}