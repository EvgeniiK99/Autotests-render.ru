package api.api_requests;

import api.models.LoginBodyModel;
import api.models.LoginResponseModel;
import io.qameta.allure.Step;

import static api.specs.BaseSpec.baseRequestWithJsonBodySpec;
import static api.specs.BaseSpec.baseResponseSpecCodeIs200;
import static io.restassured.RestAssured.given;

public class AuthorizationApi {

    @Step("Login request")
    public static LoginResponseModel login(LoginBodyModel loginData) {
        return given(baseRequestWithJsonBodySpec)
                .body(loginData)
                .when()
                .post("/user/login")
                .then()
                .spec(baseResponseSpecCodeIs200)
                .extract().as(LoginResponseModel.class);
    }
}