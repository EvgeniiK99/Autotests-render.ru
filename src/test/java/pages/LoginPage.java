package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
        SelenideElement
                emailInput = $(byAttribute("name", "login")),
                passwordInput = $(byAttribute("name", "password")),
                loginButton = $(byAttribute("type", "submit"));
        public LoginPage setEmail() {
                emailInput.setValue("wolic45238@mliok.com");
                return this;
        }
        public LoginPage setPassword() {
                passwordInput.setValue("fcff612052dd4fe6");
                return this;
        }
        public SidebarPage clickSubmitButton() {
                SidebarPage sidebarPage = new SidebarPage();
                loginButton.click();
                return sidebarPage;
        }
}
