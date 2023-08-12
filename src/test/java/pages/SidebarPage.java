package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SidebarPage {

    SelenideElement
            sidebar = $(".main-menu"),
            userMenu = $(".menu__username"),
            blogsMenu = $(byText("БЛОГИ")),
            languageMenu = $(".menu__lang");

    @Step("Open sidebar")
    public SidebarPage openSidebar() {
        sidebar.hover();
        return this;
    }

    @Step("Open login window")
    public LoginPage openLoginWindow() {
        userMenu.click();
        return new LoginPage();
    }

    @Step("Open user dropdown menu")
    public SidebarPage openUserDropdownMenu() {
        userMenu.click();
        return this;
    }

    @Step("Open blogs page")
    public BlogsPage openBlogsPage() {
        blogsMenu.click();
        return new BlogsPage();
    }

    @Step("Change language - {language}")
    public SidebarPage changeLanguage(String language) {
        languageMenu.click();
        languageMenu.$(byText(language)).click();
        return this;
    }

    @Step("Check user name")
    public SidebarPage checkUserName(String userName) {
        sidebar.$(byText(userName)).shouldBe(visible);
        return this;
    }

    @Step("Check language - {language}")
    public SidebarPage checkLanguage(String language) {
        if (language.equals("English")) {
            sidebar.shouldHave(text("Worldwide CG resource"));
            languageMenu.$(".dropdown").shouldHave(text(language));
        } else if (language.equals("Deutsch")) {
            sidebar.shouldHave(text("Weltweite CG Ressourcen"));
            languageMenu.$(".dropdown").shouldHave(text(language));
        }


        return this;
    }
}


