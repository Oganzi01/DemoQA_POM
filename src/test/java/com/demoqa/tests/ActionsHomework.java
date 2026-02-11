package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HerokuAppPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActionsHomework extends TestBase {
    HerokuAppPage page;

    @BeforeEach
    public void initPage() {
        page = new HerokuAppPage(driver);
    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        Thread.sleep(2000);
        page.dragAndDropSquares();
        Thread.sleep(3000);
    }

    @Test
    public void sliderTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        Thread.sleep(2000);
        page.moveSliderToMax();
        Thread.sleep(3000);
    }

    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        Thread.sleep(2000);
        page.hoverOverAvatar();
        Thread.sleep(3000); // Видим появившуюся подпись под аватаром
    }
}