package web.tests;

import api.api_requests.AuthorizationApi;
import api.api_requests.BlogsApi;
import api.models.LoginResponseModel;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static api.tests.TestBaseApi.credentials;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static utils.RandomUtils.getRandomBlogId;

@Owner("Evgenii Klimashin")
@Severity(NORMAL)
@Tag("blogs_tests")
@Epic("UI_Tests")
@Feature("Blogs page")
public class BlogsPageTests extends TestBase {

    @Test
    @DisplayName("Successful use filter by Name")
    void usingFilterByName() {
        blogsPage
                .openBlogsPage()
                .openFiltersAndSearch()
                .setValueInFilterByName("Август 2023")
                .closeFiltersAndSearch()
                .checkBlogInList("Август 2023");
    }

    @Test
    @DisplayName("Successful add blog to favorite")
    void addBlogToFavorite() {
        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);
        open("");
        getWebDriver().manage().addCookie(new Cookie("xf_user", loginResponse.getToken()));

        Integer blogId = getRandomBlogId();
        blogsPage
                .openBlog(blogId)
                .addBlogToFavorite()
                .checkBlogIsInFavorite();

        BlogsApi.deleteBlogFromFavorite(loginResponse, blogId);
    }

    @Test
    @DisplayName("Successful delete blog from favorite")
    void deleteBlogFromFavorite() {
        Integer blogId = getRandomBlogId();

        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);
        BlogsApi.addBlogToFavorite(loginResponse, blogId);
        open("");
        getWebDriver().manage().addCookie(new Cookie("xf_user", loginResponse.getToken()));

        blogsPage
                .openBlog(blogId)
                .deleteBlogFromFavorite()
                .checkBlogIsNotInFavorite();
    }
}