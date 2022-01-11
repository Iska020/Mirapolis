package ru.demoMirapolis;

import org.junit.Assert;
import org.junit.Test;

import static ru.demoMirapolis.SupportingClass.*;

public class AuthorizationTest extends BaseClass {

    private final static String AUTHORIZATION_PAGE_URL = "https://lmslite47vr.demo.mirapolis.ru/mira";
    private final static String SUCCESSFUL_MESSAGE = "На ваш электронный адрес отправлена инструкция " +
            "по восстановлению пароля.";
    private final static String ALERT_MESSAGE = "Пользователь с таким именем не найден.";
    private final static String CORRECT_LOGIN = "fominaelena",
            CORRECT_PASSWORD = "1P73BP4Z";
    private final static String TITLE_OF_AUTHORIZATION_PAGE = "Авторизация",
            TITLE_OF_MAIN_PAGE = "Главная страница";
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
        Assert.assertEquals(TITLE_OF_MAIN_PAGE, authorizationPage.correctInput(CORRECT_LOGIN, CORRECT_PASSWORD)
                .mainPageTextShouldBeVisible()
                .getTitle());
    }

    @Test
    public void checkIncorrectInput() {
        Assert.assertEquals(ALERT_TEXT, authorizationPage
                .incorrectInput(generateSomeString(), generateSomeString()));
    }

    @Test
    public void checkCorrectPageAfterAlert() {
        Assert.assertEquals(TITLE_OF_AUTHORIZATION_PAGE, authorizationPage
                .goToAuthorizationPageAfterAlert(CORRECT_LOGIN, generateSomeString())
                .getTitleOfAuthorizationPage());
    }

    @Test
    public void checkCorrectPasswordRecovery() {
        Assert.assertEquals(SUCCESSFUL_MESSAGE, authorizationPage
                .goToCorrectPasswordRecovery()
                .CorrectPasswordRecovery(CORRECT_LOGIN));
    }

    @Test
    public void checkIncorrectPasswordRecovery() {
        Assert.assertEquals(ALERT_MESSAGE, authorizationPage
                .goToIncorrectPasswordRecovery()
                .IncorrectPasswordRecovery(generateSomeString()));
    }

    @Test
    public void checkCorrectWorkShowPasswordButton() {
        Assert.assertEquals(PASSWORD_TYPE_ATTRIBUTE, authorizationPage.showPassword(generateSomeString()));
    }
}