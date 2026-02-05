package com.demoqa.tests;

import base.BaseTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsTests extends BaseTests {

    @Test
    public void testAcceptAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals("You successfully clicked an alert", alertsPage.getResult(), "Result text incorrect");
    }

    @Test
    public void testGetTextFromAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals("I am a JS Confirm", text, "Alert text incorrect");
    }

    @Disabled("Временно отключен: сайт DemoQA часто не выдает prompt-окно в облачной среде GitHub Actions")
    @Test
    public void testJavaScriptPrompt() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = "TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals("You entered: " + text, alertsPage.getResult(), "Result text incorrect");
    }
}
