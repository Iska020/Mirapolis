package ru.demo.mirapolis.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.demo.mirapolis.pages.AuthorizationPage;
import ru.demo.mirapolis.utils.TestUtils;
import ru.demo.mirapolis.pages.MainPage;

public class AuthorizationTest extends BaseTest {

    private final static String AUTHORIZATION_PAGE_URL = "https://lmslite47vr.demo.mirapolis.ru/mira";
    private final static String SUCCESSFUL_MESSAGE = "На ваш электронный адрес отправлена инструкция по восстановлению пароля.";
    private final static String ALERT_MESSAGE = "Пользователь с таким именем не найден.";
    private final static String CORRECT_LOGIN = "fominaelena";
    private final static String CORRECT_PASSWORD = "1P73BP4Z";
    private final static String TITLE_OF_AUTHORIZATION_PAGE = "Авторизация";
    private final static String TITLE_OF_MAIN_PAGE = "Главная страница";
    private final static String ALERT_TEXT = "Неверные данные для авторизации";
    private final static String PASSWORD_TYPE_ATTRIBUTE = "text";

    private final AuthorizationPage authorizationPage = new AuthorizationPage(AUTHORIZATION_PAGE_URL);

    @Test
    public void clickOnMirapolis() {
        authorizationPage.clickOnMirapolisIcon();
        Assert.assertEquals(TITLE_OF_AUTHORIZATION_PAGE, authorizationPage.getTitleOfAuthorizationPage());
    }

    @Test
    public void checkCorrectInput() {
        authorizationPage.fillLogin(CORRECT_LOGIN).fillPassword(CORRECT_PASSWORD).clickOnEnterButton();
        Assert.assertEquals(TITLE_OF_MAIN_PAGE, new MainPage()
                .mainPageTextShouldBeVisible()
                .getTitleOfMainPage());
    }

    @Test
    public void checkIncorrectInput() {
        authorizationPage.fillLogin(CORRECT_LOGIN).fillPassword(TestUtils.generateSomeString()).clickOnEnterButton();
        Assert.assertEquals(ALERT_TEXT, authorizationPage.getAlertText());
    }

    @Test
    public void checkCorrectPageAfterAlert() {
        authorizationPage.fillLogin(CORRECT_LOGIN).fillPassword(TestUtils.generateSomeString()).clickOnEnterButton();
        Assert.assertEquals(TITLE_OF_AUTHORIZATION_PAGE, authorizationPage
                .goToAuthorizationPageAfterAlert()
                .getTitleOfAuthorizationPage());
    }

    @Test
    public void checkCorrectPasswordRecovery() {
        Assert.assertEquals(SUCCESSFUL_MESSAGE, authorizationPage
                .goToPasswordRecovery()
                .fillLogin(CORRECT_LOGIN)
                .clickOnEnterButton()
                .getSuccessfulMessage());
    }

    @Test
    public void checkIncorrectPasswordRecovery() {
        Assert.assertEquals(ALERT_MESSAGE, authorizationPage
                .goToPasswordRecovery()
                .fillLogin(TestUtils.generateSomeString())
                .clickOnEnterButton()
                .getWrongMessage());
    }

    @Test
    public void checkCorrectWorkShowPasswordButton() {
        Assert.assertEquals(PASSWORD_TYPE_ATTRIBUTE, authorizationPage
                .fillPassword(TestUtils.generateSomeString())
                .clickOnShowPasswordButton()
                .getPasswordFieldTypeAttribute());
    }
}