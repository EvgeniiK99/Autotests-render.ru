package api_tests.api;

import api_tests.models.GetBlogListInFavoriteResponseModel;
import api_tests.models.LoginResponseModel;
import io.qameta.allure.Step;

import static api_tests.specs.GetSpec.getRequestSpec;
import static api_tests.specs.GetSpec.getResponseSpecCodeIs200;
import static io.restassured.RestAssured.given;

public class GetBlogListInFavorite {
    @Step("Get request")
    public static GetBlogListInFavoriteResponseModel getBlogListInFavorite(LoginResponseModel loginResponse) {
        return given(getRequestSpec)
                .header("Cookie", "xf_user=" + loginResponse.getToken())
                .when()
                .get("/255646/favorites/posts")
                .then()
                .spec(getResponseSpecCodeIs200)
                .extract().as(GetBlogListInFavoriteResponseModel.class);
    }
}
