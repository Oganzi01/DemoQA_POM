package com.demoqa.tests;

import com.demoqa.core.TestBase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable; 
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotTest extends TestBase {

    @Test
    
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
