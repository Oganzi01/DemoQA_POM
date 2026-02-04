package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SelectPage extends BasePage {
    public SelectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldStyleSelect;

    public void selectColorByText(String colorName) {

        Select select = new Select(oldStyleSelect);
        select.selectByVisibleText(colorName);
    }

    public String getSelectedColorText() {
        Select select = new Select(oldStyleSelect);
        return select.getFirstSelectedOption().getText();
    }
}