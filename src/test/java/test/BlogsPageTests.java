package test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import pages.BlogsPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BlogsPageTests extends TestBase {
    @Disabled
    @Test
    @Tag("blogs_tests")
    @Feature("Filters")
    @Story("Successful use filter by Name")
    @DisplayName("Use filter by Name")
    void usingFilterByName() {
        new BlogsPage()
                .openBlogsPage()
                .openFiltersAndSearch()
                .setValueInFilterByName("Август 2023")
                .closeFiltersAndSearch()
                .checkBlogInList("Август 2023");
    }
    @Test
    @Tag("blogs_tests")
    @DisplayName("Rate blog")
    void rateBlog() {
        open("https://render.ru/ru/");
        getWebDriver().manage().addCookie(new Cookie("token", "255646,gsfCqxmHxNIRrofKSi5V_OMjawFedsaW_76fVuFU"));
        open("https://render.ru/ru/EchoFreeArt/post/24578");
    }
}
