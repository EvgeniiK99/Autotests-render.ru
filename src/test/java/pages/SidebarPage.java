package pages;

import com.codeborne.selenide.Condition;
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

    public SidebarPage openSidebar() {
        sidebar.hover();
        return this;
    }

    public LoginPage openLoginWindow() {
        userMenu.click();
        return new LoginPage();
    }

    public SidebarPage openUserDropdownMenu() {
        userMenu.click();
        return this;
    }

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


