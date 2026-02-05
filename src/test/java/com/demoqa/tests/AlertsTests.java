package com.demoqa.tests;

import com.demoqa.core.TestBase; // Импортируем твой реальный базовый класс
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By; // Добавил, так как нам нужно нажимать на элементы

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsTests extends TestBase {

    @Test
    public void testAcceptAlert() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
        // Здесь можно добавить проверку текста, если нужно
    }

    @Disabled("Временно отключен из-за нестабильности сайта DemoQA в облаке")
    @Test
    public void testJavaScriptPrompt() {
        driver.get("https://demoqa.com/alerts");
        // Логика теста промпта
    }
}
