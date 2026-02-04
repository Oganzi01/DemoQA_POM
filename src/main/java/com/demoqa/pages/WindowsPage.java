package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage {
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;

    @FindBy(id = "windowButton")
    WebElement windowButton;

    @FindBy(id = "messageWindowButton")
    WebElement messageWindowButton;

    // Тот самый метод, который был "красным"
    public WindowsPage clickWindowButton() {
        click(windowButton);
        return this;
    }

    public WindowsPage clickOnClickHere() {
        click(tabButton);
        return this;
    }

    public WindowsPage clickMessageWindowButton() {
        click(messageWindowButton);
        return this;
    }

    public String getHeaderText() {
        return should(By.className("main-header")).getText();
    }

    public String getSampleText() {
        return should(By.id("sampleHeading")).getText();
    }
}