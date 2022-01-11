package ru.demoMirapolis;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

public class MainPage {

    private final SelenideElement mainPageText = $(byXpath("//span[text() = 'Главная страница']"));

    public MainPage mainPageTextShouldBeVisible() {
        mainPageText.shouldBe(visible);
        return this;
    }

    public String getTitle() {
        return title();
    }
}
