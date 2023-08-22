package api_tests.api;

import api_tests.models.AddBlogToFavoriteResponseModel;
import api_tests.models.DeleteBlogFromFavoriteResponseModel;
import api_tests.models.LoginResponseModel;
import io.qameta.allure.Step;

import static api_tests.specs.BlogsSpec.*;
import static io.restassured.RestAssured.given;

public class BlogsApi {
    @Step("Add Blog to favorite API request")
    public static AddBlogToFavoriteResponseModel addBlogToFavorite(LoginResponseModel loginResponse, Integer blogId) {
        return given(addBlogToFavoriteRequestSpec)
                .header("Cookie", "xf_user=" + loginResponse.getToken())
                .when()
                .post("/favorites/post/" + blogId)
                .then()
                .spec(addBlogToFavoriteResponseSpecCodeIs200)
                .extract().as(AddBlogToFavoriteResponseModel.class);
    }

    @Step("Delete Blog from favorite API request")
    public static DeleteBlogFromFavoriteResponseModel deleteBlogFromFavorite(LoginResponseModel loginResponse, Integer blogId) {
        return given(deleteBlogFromFavoriteRequestSpec)
                .header("Cookie", "xf_user=" + loginResponse.getToken())
                .when()
                .delete("/favorites/post/" + blogId)
                .then()
                .spec(deleteBlogFromFavoriteResponseSpecCodeIs200)
                .extract().as(DeleteBlogFromFavoriteResponseModel.class);
    }
}
