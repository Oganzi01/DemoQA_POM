package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    public String getParentFrameText() {

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1")));

        String text = driver.findElement(By.tagName("body")).getText();
        return text;
    }

    public String getChildFrameText() {

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));
        String text = driver.findElement(By.tagName("p")).getText();
        return text;
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}