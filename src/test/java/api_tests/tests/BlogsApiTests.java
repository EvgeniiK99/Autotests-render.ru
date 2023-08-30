package api_tests.tests;

import api_tests.api.AuthorizationApi;
import api_tests.api.BlogsApi;
import api_tests.api.GetBlogListInFavorite;
import api_tests.models.AddBlogToFavoriteResponseModel;
import api_tests.models.DeleteBlogFromFavoriteResponseModel;
import api_tests.models.GetBlogListInFavoriteResponseModel;
import api_tests.models.LoginResponseModel;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.*;
import static org.junit.jupiter.api.Assertions.*;

@Epic("API_Tests")
@Feature("Blogs")
public class BlogsApiTests extends TestBaseApi {
    @Test
    @DisplayName("Successful add blog to favorite")
    @Owner("Evgenii Klimashin")
    @Severity(NORMAL)
    @Tag("api_tests")
    void addBlogToFavoriteApiTest() {
        int blogId = 24577;
        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);
        GetBlogListInFavoriteResponseModel[] getBlogListInFavorite = GetBlogListInFavorite.getBlogListInFavorite(loginResponse);

        AddBlogToFavoriteResponseModel addBlogResponse = BlogsApi.addBlogToFavorite(loginResponse, blogId);
        step("Check blog in favorite", () -> {
            assertEquals(blogId, addBlogResponse.getPostId());
            //todo Переделать проверку id в массиве
            assertEquals(blogId, getBlogListInFavorite[2].getId());
            assertTrue(addBlogResponse.isFavorite());
        });

    }

    @Test
    @DisplayName("Successful delete blog from favorite")
    @Owner("Evgenii Klimashin")
    @Severity(NORMAL)
    @Tag("api_tests")
    void deleteBlogFromFavoriteApiTest() {
        Integer blogId = 24578;
        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);
        BlogsApi.addBlogToFavorite(loginResponse, blogId);
        DeleteBlogFromFavoriteResponseModel delBlogResponse = BlogsApi.deleteBlogFromFavorite(loginResponse, blogId);

        step("Check blog is not in favorite", () -> {
            assertEquals(blogId, delBlogResponse.getPostId());
            assertFalse(delBlogResponse.isFavorite());
        });
    }
}
