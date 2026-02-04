package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramesPage extends BasePage {
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "frame1")
    WebElement parentFrame;

    public String getParentFrameText() {
        // Переключаемся в родительский фрейм
        driver.switchTo().frame(parentFrame);
        // Берем текст самого тела (body) фрейма
        return driver.findElement(By.tagName("body")).getText();
    }

    public String getChildFrameText() {
        // Переключаемся в первый (и единственный) вложенный фрейм
        driver.switchTo().frame(0);
        // Ждем появления тега <p> и берем его текст
        return should(By.tagName("p")).getText();
    }

    public void exitToMainContent() {
        // Возвращаемся на главную страницу
        driver.switchTo().defaultContent();
    }
}