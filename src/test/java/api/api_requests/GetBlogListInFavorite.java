package api.api_requests;

import api.models.GetBlogListInFavoriteResponseModel;
import api.models.LoginResponseModel;
import io.qameta.allure.Step;

import static api.specs.BaseSpec.baseRequestSpec;
import static api.specs.BaseSpec.baseResponseSpecCodeIs200;
import static api.tests.TestBaseApi.accountData;
import static io.restassured.RestAssured.given;

public class GetBlogListInFavorite {

    @Step("Get request")
    public static GetBlogListInFavoriteResponseModel[] getBlogListInFavorite(LoginResponseModel loginResponse) {
        return given(baseRequestSpec)
                .header("Cookie", "xf_user=" + loginResponse.getToken())
                .when()
                .get("/user/" + accountData.getUserId() + "/favorites/posts")
                .then()
                .spec(baseResponseSpecCodeIs200)
                .extract().as(GetBlogListInFavoriteResponseModel[].class);
    }
}