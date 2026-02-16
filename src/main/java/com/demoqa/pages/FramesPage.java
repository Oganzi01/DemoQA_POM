package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FramesPage extends BasePage {

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(id = "sampleHeading")
    WebElement frameText;

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public String getParentFrameText() {

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1")));
        String text = frameText.getText();

        driver.switchTo().defaultContent();
        return text;
    }
}