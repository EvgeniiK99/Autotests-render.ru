package pages;

import io.qameta.allure.Step;
import test.TestBase;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    @Step("Open Main page")
    public MainPage openMainPage() {
        open();
        return this;
    }
}
