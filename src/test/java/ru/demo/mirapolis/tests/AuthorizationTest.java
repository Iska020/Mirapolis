package ru.demo.mirapolis.tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.demo.mirapolis.pages.AuthorizationPage;
import ru.demo.mirapolis.utils.ConfProperties;
import ru.demo.mirapolis.utils.UtilsTest;
import ru.demo.mirapolis.pages.MainPage;

public class AuthorizationTest extends BaseTest {

    @Epic("Testing for Mirapolis site")
    @Description("Test checks that the correct page is loaded after clicking on the Mirapolis icon")
    @Test
    public void clickOnMirapolis() {
        Assert.assertEquals(new AuthorizationPage(ConfProperties.getProperty("mirapolis.auth.page.url"))
                .clickOnMirapolisIcon()
                .getTitleOfAuthorizationPage(), ConfProperties.getProperty("mirapolis.auth.page.title"));
    }

    @Epic("Testing for Mirapolis site")
    @Feature("Tests for correct or incorrect input data to authorization form")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void checkCorrectInput() {
        new AuthorizationPage(ConfProperties.getProperty("mirapolis.auth.page.url"))
                .fillLogin(ConfProperties.getProperty("mirapolis.auth.page.correct.login"))
                .fillPassword(ConfProperties.getProperty("mirapolis.auth.page.correct.password"))
                .clickOnEnterButton();
        Assert.assertEquals(new MainPage()
                .mainPageTextShouldBeVisible()
                .getTitleOfMainPage(), ConfProperties.getProperty("mirapolis.main.page.title"));
    }

    @Epic("Testing for Mirapolis site")
    @Feature("Tests for correct or incorrect input data to authorization form")
    @Test
    public void checkIncorrectInput() {
        AuthorizationPage authorizationPage = new AuthorizationPage(ConfProperties
                .getProperty("mirapolis.auth.page.url"));
        authorizationPage
                .fillLogin(ConfProperties.getProperty("mirapolis.auth.page.correct.login"))
                .fillPassword(UtilsTest.generateSomeString())
                .clickOnEnterButton();
        Assert.assertEquals(authorizationPage.getAlertText(), ConfProperties
                .getProperty("mirapolis.auth.page.alert.message"));
    }

    @Epic("Testing for Mirapolis site")
    @Test
    public void checkCorrectPageAfterAlert() {
        AuthorizationPage authorizationPage = new AuthorizationPage(ConfProperties
                .getProperty("mirapolis.auth.page.url"));
        authorizationPage
                .fillLogin(ConfProperties.getProperty("mirapolis.auth.page.correct.login"))
                .fillPassword(UtilsTest.generateSomeString())
                .clickOnEnterButton();
        Assert.assertEquals(authorizationPage
                .goToAuthorizationPageAfterAlert()
                .getTitleOfAuthorizationPage(), ConfProperties.getProperty("mirapolis.auth.page.title"));
    }

    @Epic("Testing for Mirapolis site")
    @Feature("Tests for correct or incorrect password recovery after input data to authorization form")
    @Test
    public void checkCorrectPasswordRecovery() {
        Assert.assertEquals(new AuthorizationPage(ConfProperties.getProperty("mirapolis.auth.page.url"))
                .goToPasswordRecovery()
                .fillLogin(ConfProperties.getProperty("mirapolis.auth.page.correct.login"))
                .clickOnEnterButton()
                .getSuccessfulMessage(), ConfProperties
                .getProperty("mirapolis.password.recovery.page.successful.message"));
    }

    @Epic("Testing for Mirapolis site")
    @Feature("Tests for correct or incorrect password recovery after input data to authorization form")
    @Test
    public void checkIncorrectPasswordRecovery() {
        Assert.assertEquals(new AuthorizationPage(ConfProperties.getProperty("mirapolis.auth.page.url"))
                .goToPasswordRecovery()
                .fillLogin(UtilsTest.generateSomeString())
                .clickOnEnterButton()
                .getWrongMessage(), ConfProperties.getProperty("mirapolis.password.recovery.page.alert.message"));
    }

    @Epic("Testing for Mirapolis site")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void checkCorrectWorkShowPasswordButton() {
        Assert.assertEquals(new AuthorizationPage(ConfProperties.getProperty("mirapolis.auth.page.url"))
                .fillPassword(UtilsTest.generateSomeString())
                .clickOnShowPasswordButton()
                .getPasswordFieldTypeAttribute(), ConfProperties
                .getProperty("mirapolis.auth.page.password.type.attribute"));
    }
}
