package api_tests.api;

import api_tests.models.BlogsResponseModel;
import api_tests.models.LoginResponseModel;
import io.qameta.allure.Step;

import static api_tests.specs.BaseSpec.baseRequestSpec;
import static api_tests.specs.BaseSpec.baseResponseSpecCodeIs200;
import static io.restassured.RestAssured.given;

public class BlogsApi {
    @Step("Add Blog to favorite API request")
    public static BlogsResponseModel addBlogToFavorite(LoginResponseModel loginResponse, Integer blogId) {
        return given(baseRequestSpec)
                .header("Cookie", "xf_user=" + loginResponse.getToken())
                .when()
                .post("/favorites/post/" + blogId)
                .then()
                .spec(baseResponseSpecCodeIs200)
                .extract().as(BlogsResponseModel.class);
    }

    @Step("Delete Blog from favorite API request")
    public static BlogsResponseModel deleteBlogFromFavorite(LoginResponseModel loginResponse, Integer blogId) {
        return given(baseRequestSpec)
                .header("Cookie", "xf_user=" + loginResponse.getToken())
                .when()
                .delete("/favorites/post/" + blogId)
                .then()
                .spec(baseResponseSpecCodeIs200)
                .extract().as(BlogsResponseModel.class);
    }
}
