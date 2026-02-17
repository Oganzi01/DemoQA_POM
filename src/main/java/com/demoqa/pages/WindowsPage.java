package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;

public class WindowsPage extends BasePage {
    // Локаторы
    private final By tabButton = By.id("tabButton");
    private final By windowButton = By.id("windowButton");
    private final By sampleHeading = By.id("sampleHeading");

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    private void clickWithScroll(By locator) {
        // Ждем появления элемента в структуре страницы
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        // Прокручиваем страницу до кнопки, чтобы её не перекрывала реклама
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // Кликаем через JS для надежности
        forceClickJS(locator);
    }

    public void clickOnClickHere() {
        clickWithScroll(tabButton);
    }

    public void clickWindowButton() {
        clickWithScroll(windowButton);
    }

    public void switchToTab(int index) {
        // Ждем, пока откроется второе окно/вкладка
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }

    public String getSampleText() {
        // Ждем появления текста в новой вкладке
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sampleHeading)).getText();
    }
}