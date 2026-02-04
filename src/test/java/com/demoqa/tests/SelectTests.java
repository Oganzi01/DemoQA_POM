package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.SelectPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectTests extends TestBase {

    @Test
    public void testSelectColor() {
        driver.get("https://demoqa.com/select-menu");
        SelectPage selectPage = new SelectPage(driver);

        // Выбираем цвет "Aqua"
        selectPage.selectColorByText("Aqua");

        // Проверяем, что он выбрался
        assertEquals("Aqua", selectPage.getSelectedColorText());
    }
}
