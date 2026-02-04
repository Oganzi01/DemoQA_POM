package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.WindowsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WindowTests extends TestBase {

    WindowsPage windowsPage;

    @BeforeEach
    public void precondition() {
        // Переходим сразу в раздел Browser Windows, чтобы не тратить время на навигацию
        driver.get("https://demoqa.com/browser-windows");
        windowsPage = new WindowsPage(driver);
    }

    @Test
    public void testNewWindowTab() {
        // 1. Нажимаем на кнопку открытия новой вкладки
        windowsPage.clickOnClickHere();

        // 2. Переключаемся на вторую вкладку (индекс 1)
        windowsPage.switchToTab(1);

        // 3. Проверяем текст на новой странице
        String actualText = windowsPage.getSampleText();
        assertTrue(actualText.contains("sample"),
                "Ожидаемый текст 'sample' не найден на новой вкладке! Найдено: " + actualText);

        // 4. Закрываем текущую вкладку и возвращаемся на главную
        driver.close();
        windowsPage.switchToTab(0);
    }

    @Test
    public void testNewWindow() {
        // Тест для кнопки "New Window"
        windowsPage.clickWindowButton();

        windowsPage.switchToTab(1);

        assertTrue(windowsPage.getSampleText().contains("sample"),
                "Текст в новом окне не соответствует ожидаемому");

        driver.close();
        windowsPage.switchToTab(0);
    }
}