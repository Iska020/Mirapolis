package ru.demoMirapolis.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

public abstract class BaseTest {

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Iskan\\Documents\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1600x900";
        Configuration.headless = false;
    }

    @Before
    public void init() {
        setUp();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}