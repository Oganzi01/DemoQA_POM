package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    WebElement alertsFrameWindowCard;

    @FindBy(xpath = "//h5[text()='Elements']")
    WebElement elementsCard;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAlertsCard() {
        wait.until(ExpectedConditions.elementToBeClickable(alertsFrameWindowCard));
        click(alertsFrameWindowCard);
    }

    public void clickOnElementsCard() {
        wait.until(ExpectedConditions.elementToBeClickable(elementsCard));
        click(elementsCard);
    }
}