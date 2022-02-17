package ru.demo.mirapolis.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

public abstract class BaseTest {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Iskan\\IdeaProjects\\chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1600x900";
        Configuration.headless = false;
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}