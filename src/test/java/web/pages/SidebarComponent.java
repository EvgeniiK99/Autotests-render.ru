package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SidebarComponent {

    private final SelenideElement
            sidebar = $(".main-menu"),
            userMenu = $(".menu__username"),
            languageMenu = $(".menu__lang");

    @Step("Open sidebar")
    public SidebarComponent openSidebar() {
        sidebar.hover();
        return this;
    }

    @Step("Open login window")
    public LoginPage openLoginWindow() {
        userMenu.click();
        return new LoginPage();
    }

    @Step("Open user dropdown menu")
    public SidebarComponent openUserDropdownMenu() {
        userMenu.click();
        return this;
    }

    @Step("Change language - {language}")
    public SidebarComponent changeLanguage(String language) {
        languageMenu.click();
        languageMenu.$(byText(language)).click();
        return this;
    }

    @Step("Check user name")
    public void checkUserName(String userName) {
        sidebar.$(byText(userName)).shouldBe(visible);
    }

    @Step("Check language - {language}")
    public void checkLanguage(String language, String header) {
        sidebar.shouldHave(text(header));
        languageMenu.$(".dropdown").shouldHave(text(language));
    }
}