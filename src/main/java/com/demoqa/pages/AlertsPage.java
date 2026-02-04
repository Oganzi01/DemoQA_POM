package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public AlertsPage clickPromptButton() {
        // На DemoQA id кнопки именно с опечаткой 'promtButton'
        click(should(By.id("promtButton")));
        return this;
    }

    public AlertsPage sendTextToAlert(String text) {
        switchToAlert().sendKeys(text);
        return this;
    }

    public AlertsPage acceptAlert() {
        switchToAlert().accept();
        return this;
    }

    public String getPromptResultText() {
        return should(By.id("promptResult")).getText();
    }

    public String getResultText() {
        // Для обычных алертов/конфирмов
        return should(By.id("confirmResult")).getText();
    }
}