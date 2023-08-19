package api_tests.tests;

import api_tests.models.AddedBlogToFavoriteResponseModel;
import api_tests.models.LoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api_tests.specs.BlogsSpec.addBlogToFavoriteRequestSpec;
import static api_tests.specs.BlogsSpec.addBlogToFavoriteResponseSpecCodeIs200;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class BlogsApiTests extends TestBaseApi {
    @Test
    @DisplayName("Successful added blog to favotite")
    @Tag("api_tests")
    void addBlogToFavoriteApiTest() {

//        loginData.setLogin(accountData.getEmail());
//        loginData.setPassword(accountData.getPassword());
        LoginResponseModel loginResponse = authorizationApi.login(credentials);

        AddedBlogToFavoriteResponseModel addedBlogToFavoriteResponse = step("Add Blog to favorite request", ()->
                given(addBlogToFavoriteRequestSpec)
                        .header("Cookie", "xf_user=" + loginResponse.getToken())
                        .when()
                        .post("/favorites/post/24578")
                        .then()
                        .spec(addBlogToFavoriteResponseSpecCodeIs200)
                        .extract().as(AddedBlogToFavoriteResponseModel.class));
        step("Check blog in favorite", ()-> {
            assertEquals(24578, addedBlogToFavoriteResponse.getPostId());
            assertTrue(addedBlogToFavoriteResponse.isFavorite());
        });


    }
}
