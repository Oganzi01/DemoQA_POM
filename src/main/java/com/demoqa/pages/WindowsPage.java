package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class WindowsPage extends BasePage {

    @FindBy(id = "tabButton")
    WebElement tabButton;

    @FindBy(id = "windowButton")
    WebElement windowButton;

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnClickHere() {
        wait.until(ExpectedConditions.elementToBeClickable(tabButton));
        click(tabButton);
    }

    public void clickWindowButton() {
        wait.until(ExpectedConditions.elementToBeClickable(windowButton));
        click(windowButton);
    }

    public void switchToNewWindow(int index) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    public String getHeaderText() {
        return wait.until(ExpectedConditions.visibilityOf(sampleHeading)).getText();
    }
}