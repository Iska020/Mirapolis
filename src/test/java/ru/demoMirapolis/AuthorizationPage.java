package ru.demoMirapolis;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage {

    private final SelenideElement mirapolisIcon = $(".head a");
    private final SelenideElement inputLogin = $("input[type = 'text']"),
            inputPassword = $("input[name = 'password']"),
            enterButton = $("button[type = 'submit']");
    private final SelenideElement forgotPassword = $(".mira-default-login-page-link div");
    private final SelenideElement showPasswordButton = $("#show_password");
    private final SelenideElement enterInSystemElement = $(".body");

    public AuthorizationPage(String url) {
        open(url);
    }

    public String getTitleOfAuthorizationPage() {
        return title();
    }

    public void clickOnMirapolisIcon() {
        mirapolisIcon.click();
    }

    public void inputFieldsAndClickOnEnterButton(String someLogin, String somePassword) {
        inputLogin.setValue(someLogin);
        inputPassword.setValue(somePassword);
        enterButton.click();
    }

    public MainPage correctInput(String correctLogin, String correctPassword) {
        inputFieldsAndClickOnEnterButton(correctLogin, correctPassword);
        return new MainPage();
    }

    public String incorrectInput(String incorrectLogin, String incorrectPassword) {
        inputFieldsAndClickOnEnterButton(incorrectLogin, incorrectPassword);
        return switchTo().alert().getText();
    }

    public AuthorizationPage goToAuthorizationPageAfterAlert(String correctLogin, String incorrectPassword) {
        inputFieldsAndClickOnEnterButton(correctLogin, incorrectPassword);
        switchTo().alert().accept();
        enterInSystemElement.shouldBe(visible);
        return this;
    }

    public PasswordRecoveryPage goToPasswordRecovery() {
        forgotPassword.click();
        return new PasswordRecoveryPage();
    }

    public String showPassword(String somePassword) {
        inputPassword.setValue(somePassword);
        showPasswordButton.click();
        return inputPassword.getAttribute("type");
    }
}
