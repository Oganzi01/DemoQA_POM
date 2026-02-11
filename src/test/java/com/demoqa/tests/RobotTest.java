package com.demoqa.tests;

import com.demoqa.core.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable; // Импортируем аннотацию
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotTest extends TestBase {

    @Test
    // ЧИТАТЬ ТАК: "Отключи этот тест, если переменная GITHUB_ACTIONS равна true"
    @DisabledIfEnvironmentVariable(named = "GITHUB_ACTIONS", matches = "true")
    public void robotScrollTest() throws Exception {
        Thread.sleep(2000);
        Robot robot = new Robot();

        System.out.println("Робот начинает скроллинг...");
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        Thread.sleep(1000);

        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        System.out.println("Скроллинг завершен.");
    }
}