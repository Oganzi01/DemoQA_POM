package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.FramesPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NestedFramesTests extends TestBase {

    @Test
    public void testNestedFrames() {
        driver.get("https://demoqa.com/nestedframes");
        FramesPage framesPage = new FramesPage(driver);

        // 1. Проверяем родительский фрейм
        String parentText = framesPage.getParentFrameText();
        System.out.println("Parent text found: " + parentText);
        // Используем toLowerCase(), чтобы регистр букв не мешал
        assertTrue(parentText.toLowerCase().contains("parent frame"), "Текст родителя не найден!");

        // 2. Проверяем вложенный фрейм
        String childText = framesPage.getChildFrameText();
        System.out.println("Child text found: " + childText);
        // Здесь тоже переводим в нижний регистр для надежности
        assertTrue(childText.toLowerCase().contains("child iframe"), "Текст ребенка не найден!");

        framesPage.exitToMainContent();
    }
}