package api_tests.tests;

import api_tests.api.AuthorizationApi;
import api_tests.api.BlogsApi;
import api_tests.api.GetBlogListInFavorite;
import api_tests.models.AddBlogToFavoriteResponseModel;
import api_tests.models.DeleteBlogFromFavoriteResponseModel;
import api_tests.models.GetBlogListInFavoriteResponseModel;
import api_tests.models.LoginResponseModel;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

@Epic("API_Tests")
public class BlogsApiTests extends TestBaseApi {
    @Test
    @DisplayName("Successful add blog to favorite")
    @Tag("api_tests")
    void addBlogToFavoriteApiTest() {
        int blogId = 24577;
        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);
//        GetBlogListInFavoriteResponseModel getBlogListInFavorite = GetBlogListInFavorite.getBlogListInFavorite(loginResponse);
//        int listSize = getBlogListInFavorite.getBlogList().size();
        AddBlogToFavoriteResponseModel addBlogResponse = BlogsApi.addBlogToFavorite(loginResponse, blogId);

        step("Check blog in favorite", () -> {
            assertEquals(blogId, addBlogResponse.getPostId());
            assertTrue(addBlogResponse.isFavorite());
        });
    }

    @Test
    @DisplayName("Successful delete blog from favorite")
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
