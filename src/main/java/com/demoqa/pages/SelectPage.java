package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectPage extends BasePage {

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectPage(WebDriver driver) {
        super(driver);
    }

    public void selectColorByText(String text) {
        scrollToElement(oldSelectMenu);
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(text);
    }

    public String getSelectedValue() {
        Select select = new Select(oldSelectMenu);
        return select.getFirstSelectedOption().getText();
    }
}