package test;

import api_tests.api.AuthorizationApi;
import api_tests.models.LoginResponseModel;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import pages.BlogsPage;

import static api_tests.tests.TestBaseApi.credentials;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Feature("Blogs page")
public class BlogsPageTests extends TestBase {

    @Test
    @Tag("blogs_tests")
    @DisplayName("Successful use filter by Name")
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
    @DisplayName("Successful add blog to favorite")
    void addBlogToFavorite() {
        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);
        open("");
        getWebDriver().manage().addCookie(new Cookie("xf_user", loginResponse.getToken()));
        new BlogsPage()
                .openBlog(1111)
                .addBlogToFavorite();
        //todo Добавить проверки
    }
}
