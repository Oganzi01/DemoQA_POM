package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SelectPage extends BasePage {

    private final By oldSelectMenu = By.id("oldSelectMenu");

    public SelectPage(WebDriver driver) {
        super(driver);
    }

    public void selectColorByText(String text) {
        hideAds();

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(oldSelectMenu));


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public String getSelectedColorText() {

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(oldSelectMenu));
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }
}