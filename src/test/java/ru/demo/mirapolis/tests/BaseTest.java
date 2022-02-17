package ru.demo.mirapolis.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import ru.demo.mirapolis.utils.ConfProperties;

public abstract class BaseTest {

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chrome.driver.path"));
        System.setProperty("selenide.browser", "Chrome");
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1600x900";
        Configuration.headless = true;
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
