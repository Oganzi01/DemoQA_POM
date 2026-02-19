package com.demoqa.tests;

import com.demoqa.core.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

public class RobotTest extends TestBase {

    @Test
    public void scrollPageTest() {
        driver.get("https://demoqa.com/automation-practice-form");

        System.out.println("Начинаем скроллинг через JavaScript...");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        System.out.println("Скроллинг завершен успешно.");
    }
}