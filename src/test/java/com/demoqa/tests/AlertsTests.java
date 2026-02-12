package com.demoqa.tests;

import com.demoqa.core.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AlertsTests extends TestBase {

    @Test
    @Tag("smoky")
    @DisplayName("Проверка алерта с выбором")
    public void alertWithSelectTest() {

        // driver.findElement(By.id("confirmButton")).click();
        // driver.switchTo().alert().accept();
    }

    @Test
    @DisplayName("Обычный тест без тега")
    public void regularTest() {

    }
}