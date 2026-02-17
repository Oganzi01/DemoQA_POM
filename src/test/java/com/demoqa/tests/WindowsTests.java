package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.WindowsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WindowsTests extends TestBase {

    WindowsPage windowsPage;

    @BeforeEach
    public void precondition() {
        // Увеличиваем окно, чтобы элементы не прятались
        driver.manage().window().maximize();

        // Переходим на сайт
        driver.get("https://demoqa.com/browser-windows");

        // Ждем полной загрузки страницы через JS
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
        );

        windowsPage = new WindowsPage(driver);
    }

    @Test
    public void testNewWindowTab() {
        windowsPage.clickOnClickHere();
        windowsPage.switchToTab(1);

        String actualText = windowsPage.getSampleText();
        assertTrue(actualText.contains("sample"), "Текст не найден!");

        driver.close();
        windowsPage.switchToTab(0);
    }

    @Test
    public void testNewWindow() {
        windowsPage.clickWindowButton();
        windowsPage.switchToTab(1);

        assertTrue(windowsPage.getSampleText().contains("sample"), "Текст не найден!");

        driver.close();
        windowsPage.switchToTab(0);
    }
}