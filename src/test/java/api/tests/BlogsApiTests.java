package api.tests;

import api.api_requests.AuthorizationApi;
import api.api_requests.BlogsApi;
import api.api_requests.GetBlogListInFavorite;
import api.models.BlogsResponseModel;
import api.models.GetBlogListInFavoriteResponseModel;
import api.models.LoginResponseModel;
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
import static utils.RandomUtils.getRandomBlogId;

@Owner("Evgenii Klimashin")
@Severity(NORMAL)
@Tag("api")
@Epic("API_Tests")
@Feature("Blogs")
public class BlogsApiTests extends TestBaseApi {

    @Test
    @DisplayName("Successful add blog to favorite")
    void addBlogToFavoriteApiTest() {
        int blogId = getRandomBlogId();

        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);
        BlogsResponseModel addBlogResponse = BlogsApi.addBlogToFavorite(loginResponse, blogId);
        GetBlogListInFavoriteResponseModel[] getBlogListInFavorite = GetBlogListInFavorite.getBlogListInFavorite(loginResponse);

        step("Check blog in favorite", () -> {
            assertEquals(blogId, addBlogResponse.getPostId());
            assertEquals(blogId, getBlogListInFavorite[getBlogListInFavorite.length - 1].getId());
            assertTrue(addBlogResponse.isFavorite());
        });
        BlogsApi.deleteBlogFromFavorite(loginResponse, blogId);

    }

    @Test
    @DisplayName("Successful delete blog from favorite")
    void deleteBlogFromFavoriteApiTest() {
        int blogId = getRandomBlogId();

        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);
        BlogsApi.addBlogToFavorite(loginResponse, blogId);
        BlogsResponseModel delBlogResponse = BlogsApi.deleteBlogFromFavorite(loginResponse, blogId);

        step("Check blog is not in favorite", () -> {
            assertEquals(blogId, delBlogResponse.getPostId());
            assertFalse(delBlogResponse.isFavorite());
        });
    }
}
