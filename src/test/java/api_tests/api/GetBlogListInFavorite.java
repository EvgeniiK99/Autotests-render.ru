package api_tests.api;

import api_tests.models.GetBlogListInFavoriteResponseModel;
import api_tests.models.LoginResponseModel;
import io.qameta.allure.Step;

import static api_tests.specs.BaseSpec.baseRequestSpec;
import static api_tests.specs.BaseSpec.baseResponseSpecCodeIs200;
import static api_tests.tests.TestBaseApi.accountData;
import static io.restassured.RestAssured.given;

public class GetBlogListInFavorite {
    @Step("Get request")
    public static GetBlogListInFavoriteResponseModel[] getBlogListInFavorite(LoginResponseModel loginResponse) {
        return given(baseRequestSpec)
                .header("Cookie", "xf_user=" + loginResponse.getToken())
                .when()
                .get("/" + accountData.getUserId() + "/favorites/posts")
                .then()
                .spec(baseResponseSpecCodeIs200)
                .extract().as(GetBlogListInFavoriteResponseModel[].class);
    }
}
