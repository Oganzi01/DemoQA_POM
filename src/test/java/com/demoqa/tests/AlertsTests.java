package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.AlertsPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertsTests extends TestBase {

    @Test
    public void testJavaScriptPrompt() {
        // Идем на правильный сайт
        driver.get("https://demoqa.com/alerts");

        AlertsPage alertsPage = new AlertsPage(driver);
        String text = "UpTeam 2026";

        alertsPage.clickPromptButton()
                .sendTextToAlert(text)
                .acceptAlert();

        assertTrue(alertsPage.getPromptResultText().contains(text), "Текст не найден!");
    }
}