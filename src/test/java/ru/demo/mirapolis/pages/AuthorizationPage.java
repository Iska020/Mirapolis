package ru.demo.mirapolis.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class AuthorizationPage {

    private final SelenideElement mirapolisIcon = $(".head a");
    private final SelenideElement inputLogin = $("input[name = 'user']");
    private final SelenideElement inputPassword = $("input[name = 'password']");
    private final SelenideElement enterButton = $("button[type = 'submit']");
    private final SelenideElement forgotPassword = $(".mira-default-login-page-link div");
    private final SelenideElement showPasswordButton = $("#show_password");

    public AuthorizationPage(String url) {
        open(url);
    }

    public String getTitleOfAuthorizationPage() {
        return title();
    }

    public AuthorizationPage clickOnMirapolisIcon() {
        mirapolisIcon.click();
        return this;
    }

    public AuthorizationPage fillLogin(String login) {
        inputLogin.setValue(login);
        return this;
    }

    public AuthorizationPage fillPassword(String password) {
        inputPassword.setValue(password);
        return this;
    }

    public void clickOnEnterButton() {
        enterButton.click();
    }

    public String getAlertText() {
        return switchTo().alert().getText();
    }

    public AuthorizationPage goToAuthorizationPageAfterAlert() {
        switchTo().alert().accept();
        return this;
    }

    public PasswordRecoveryPage goToPasswordRecovery() {
        forgotPassword.click();
        return new PasswordRecoveryPage();
    }

    public AuthorizationPage clickOnShowPasswordButton() {
        showPasswordButton.click();
        return this;
    }

    public String getPasswordFieldTypeAttribute() {
        return inputPassword.getAttribute("type");
    }
}
