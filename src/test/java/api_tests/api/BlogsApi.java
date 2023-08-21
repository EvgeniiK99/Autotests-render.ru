package api_tests.api;

import api_tests.models.AddedBlogToFavoriteResponseModel;
import api_tests.models.LoginResponseModel;
import io.qameta.allure.Step;

import static api_tests.specs.BlogsSpec.addBlogToFavoriteRequestSpec;
import static api_tests.specs.BlogsSpec.addBlogToFavoriteResponseSpecCodeIs200;
import static io.restassured.RestAssured.given;

public class BlogsApi {
    @Step("Add Blog to favorite request")
    public static AddedBlogToFavoriteResponseModel addBlogToFavorite(LoginResponseModel loginResponse, Integer blogId) {
        return given(addBlogToFavoriteRequestSpec)
                        .header("Cookie", "xf_user=" + loginResponse.getToken())
                        .when()
                        .post("/favorites/post/" + blogId)
                        .then()
                        .spec(addBlogToFavoriteResponseSpecCodeIs200)
                        .extract().as(AddedBlogToFavoriteResponseModel.class);
    }
}
