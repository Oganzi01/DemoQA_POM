package com.demoqa.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

@ExtendWith(MyListener.class)
public class TestBase {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

       
        if (System.getenv("GITHUB_ACTIONS") != null) {
            
            options.addArguments("--headless"); 
            options.addArguments("--no-sandbox"); 
            options.addArguments("--disable-dev-shm-usage"); 
            options.addArguments("--window-size=1920,1080"); 
        }

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        if (System.getenv("GITHUB_ACTIONS") == null) {
            driver.manage().window().maximize();
        }

        driver.get("https://demoqa.com/");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
