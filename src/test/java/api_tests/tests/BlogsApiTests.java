package api_tests.tests;

import api_tests.api.AuthorizationApi;
import api_tests.api.BlogsApi;
import api_tests.models.AddedBlogToFavoriteResponseModel;
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
    @DisplayName("Successful added blog to favotite")
    @Tag("api_tests")
    void addBlogToFavoriteApiTest() {
        Integer blogId = 24578;
        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);
        AddedBlogToFavoriteResponseModel addBlogResponse = BlogsApi.addBlogToFavorite(loginResponse, blogId);

        step("Check blog in favorite", ()-> {
            assertEquals(blogId, addBlogResponse.getPostId());
            assertTrue(addBlogResponse.isFavorite());
        });


    }
}
