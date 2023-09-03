package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement
            emailInput = $(byAttribute("name", "login")),
            passwordInput = $(byAttribute("name", "password")),
            loginButton = $(byAttribute("type", "submit")),
            errorMessage = $(".loginError");

    @Step("Set Email")
    public LoginPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Set Password")
    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Click Submit button")
    public LoginPage clickSubmitButton() {
        loginButton.click();
        return this;
    }

    @Step("Try click Submit button")
    public void tryClickSubmitButton() {
        loginButton.shouldBe(disabled);
    }

    @Step("Check error authorization message")
    public void checkErrorAuthMessage(String errorText) {
        errorMessage.shouldHave(text(errorText));
    }
}