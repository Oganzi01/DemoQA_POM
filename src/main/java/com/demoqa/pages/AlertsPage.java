package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {

    @FindBy(id = "alertButton")
    WebElement alertButton;

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void clickAlertButton() {
        wait.until(ExpectedConditions.elementToBeClickable(alertButton));
        click(alertButton);
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickConfirmButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        click(confirmButton);
    }

    public void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public String getConfirmResult() {
        wait.until(ExpectedConditions.visibilityOf(confirmResult));
        return confirmResult.getText();
    }
}