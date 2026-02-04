package com.demoqa.pages;

import com.demoqa.core.BasePage;
import com.demoqa.pages.bookStore.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage getBookStore() {
        // Ищем 6-ю карточку (Book Store обычно шестая)
        click(should(By.xpath("(//div[@class='card mt-4 top-card'])[6]")));
        return new LoginPage(driver);
    }

    public HomePage getAlertsFrameWindows() {
        // Ищем 3-ю карточку (Alerts)
        click(should(By.xpath("(//div[@class='card mt-4 top-card'])[3]")));
        return this;
    }
}