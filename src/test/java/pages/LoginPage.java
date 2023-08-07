package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {
    SelenideElement
            emailInput = $(byAttribute("name", "login")),
            passwordInput = $(byAttribute("name", "password")),
            loginButton = $(byAttribute("type", "submit")),
            errorMessage = $(".loginError");

    public LoginPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    public SidebarPage clickSubmitButton() {
        loginButton.click();
        return new SidebarPage();
    }
//        public LoginPage clickSubmitButton() {
//                loginButton.click();
//                return this;
//        }

    public SidebarPage tryClickSubmitButton() {
        loginButton.shouldBe(disabled);
        return new SidebarPage();
    }

    public LoginPage checkErrorAuthMessage() {
        errorMessage.shouldHave(text("Ошибка авторизации"));
        return this;
    }

}
