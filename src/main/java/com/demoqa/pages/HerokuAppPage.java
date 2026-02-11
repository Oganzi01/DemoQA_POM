package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HerokuAppPage {
    private WebDriver driver;
    private Actions actions;

    public HerokuAppPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    private final By columnA = By.id("column-a");
    private final By columnB = By.id("column-b");
    private final By slider = By.cssSelector("input");
    private final By avatar = By.className("figure");

    public void dragAndDropSquares() {
        actions.dragAndDrop(driver.findElement(columnA), driver.findElement(columnB)).perform();
    }

    public void moveSliderToMax() {

        actions.dragAndDropBy(driver.findElement(slider), 100, 0).perform();
    }

    public void hoverOverAvatar() {
        actions.moveToElement(driver.findElement(avatar)).perform();
    }
}