package ru.demo.mirapolis.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PasswordRecoveryPage {

    private final SelenideElement inputLogin = $("input[name = 'loginOrEmail']");
    private final SelenideElement successfulMessage = $(".success");
    private final SelenideElement alertMessage = $(".alert");
    private final SelenideElement enterButton = $("button[type = 'submit']");

    public PasswordRecoveryPage fillLogin(String login) {
        inputLogin.setValue(login);
        return this;
    }

    public PasswordRecoveryPage clickOnEnterButton() {
        enterButton.click();
        return this;
    }

    public String getSuccessfulMessage() {
        return successfulMessage.getText();
    }

    public String getWrongMessage() {
        return alertMessage.getText();
    }
}
