package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    SelenideElement
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
        return new LoginPage();
    }

    @Step("Try click Submit button")
    public SidebarPage tryClickSubmitButton() {
        loginButton.shouldBe(disabled);
        return new SidebarPage();
    }
    @Step("Check error authorization message")
    public LoginPage checkErrorAuthMessage(String errorText) {
        errorMessage.shouldHave(text(errorText));
        return this;
    }

}
