package com.demoqa.tests;

import com.demoqa.core.TestBase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled("Весь класс временно отключен: DemoQA слишком нестабилен для GitHub Actions")
public class AlertsTests extends TestBase {

    @Test
    public void testAcceptAlert() {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void testJavaScriptPrompt() {
        driver.get("https://demoqa.com/alerts");
        // Логика теста
    }
}
