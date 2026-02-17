package com.demoqa.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoaded() {
        try {
            wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {}
    }

    public void hideAds() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("var ads = document.querySelectorAll('[id^=\"google_ads_\"], ins, footer, #adplus-anchor, #fixedban');" +
                    "for (var i = 0; i < ads.length; i++) { ads[i].remove(); }");
        } catch (Exception e) {}
    }

    protected void click(WebElement element) {
        waitForPageLoaded();
        hideAds();
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void type(WebElement element, String text) {
        waitForPageLoaded();
        hideAds();
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    protected void forceClickJS(By locator) {
        waitForPageLoaded();
        hideAds();
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }
}