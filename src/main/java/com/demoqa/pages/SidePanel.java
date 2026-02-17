package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

    @FindBy(xpath = "//span[text()='Browser Windows']")
    WebElement browserWindowsMenu;

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    public void selectBrowserWindowsMenu() {
        click(browserWindowsMenu);
    }
}