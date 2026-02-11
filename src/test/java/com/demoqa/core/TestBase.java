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

        // Проверяем, запущены ли мы на GitHub Actions
        if (System.getenv("GITHUB_ACTIONS") != null) {
            // Настройки для сервера (Linux)
            options.addArguments("--headless"); // Запуск без окна
            options.addArguments("--no-sandbox"); // Важно для Linux-серверов
            options.addArguments("--disable-dev-shm-usage"); // Чтобы не переполнялась память
            options.addArguments("--window-size=1920,1080"); // Задаем размер экрана
        }

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Опционально: разворачиваем на весь экран, если мы НЕ на сервере
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