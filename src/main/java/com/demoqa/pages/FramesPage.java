package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public String getParentFrameText() {
        waitForPageLoaded();
        hideAds();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1")));
        String text = driver.findElement(By.id("sampleHeading")).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public String getChildFrameText() {
        waitForPageLoaded();
        hideAds();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));
        String text = driver.findElement(By.tagName("p")).getText();
        driver.switchTo().defaultContent();
        return text;
    }

    public void exitToMainContent() {
        driver.switchTo().defaultContent();
    }
}