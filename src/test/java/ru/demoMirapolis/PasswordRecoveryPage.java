package ru.demoMirapolis;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PasswordRecoveryPage {

    private final SelenideElement inputLogin = $("input[type = 'text']");
    private final SelenideElement successfulMessage = $(".success"),
            alertMessage = $(".alert");
    private final SelenideElement enterButton = $("button[type = 'submit']");

    public String CorrectPasswordRecovery(String correctLogin) {
        inputLogin.setValue(correctLogin).pressEnter();
        return successfulMessage.getText();
    }

    public String IncorrectPasswordRecovery(String incorrectLogin) {
        inputLogin.setValue(incorrectLogin);
        enterButton.click();
        return alertMessage.getText();
    }
}
