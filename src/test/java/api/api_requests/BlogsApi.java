package api.api_requests;

import api.models.BlogsResponseModel;
import api.models.LoginResponseModel;
import io.qameta.allure.Step;

import static api.specs.BaseSpec.baseRequestSpec;
import static api.specs.BaseSpec.baseResponseSpecCodeIs200;
import static io.restassured.RestAssured.given;

public class BlogsApi {

    @Step("Add Blog to favorite API request")
    public static BlogsResponseModel addBlogToFavorite(LoginResponseModel loginResponse, Integer blogId) {
        return given(baseRequestSpec)
                .header("Cookie", "xf_user=" + loginResponse.getToken())
                .when()
                .post("/user/favorites/post/" + blogId)
                .then()
                .spec(baseResponseSpecCodeIs200)
                .extract().as(BlogsResponseModel.class);
    }

    @Step("Delete Blog from favorite API request")
    public static BlogsResponseModel deleteBlogFromFavorite(LoginResponseModel loginResponse, Integer blogId) {
        return given(baseRequestSpec)
                .header("Cookie", "xf_user=" + loginResponse.getToken())
                .when()
                .delete("/user/favorites/post/" + blogId)
                .then()
                .spec(baseResponseSpecCodeIs200)
                .extract().as(BlogsResponseModel.class);
    }
}