package api_tests.api;

import api_tests.models.LoginBodyModel;
import api_tests.models.LoginResponseModel;
import io.qameta.allure.Step;

import static api_tests.specs.BaseSpec.baseResponseSpecCodeIs200;
import static api_tests.specs.LoginSpec.loginRequestSpec;
import static io.restassured.RestAssured.given;

public class AuthorizationApi{

    @Step("Login request")
    public static LoginResponseModel login(LoginBodyModel loginData) {
        return given(loginRequestSpec)
                .body(loginData)
                .when()
                .post("/login")
                .then()
                .spec(baseResponseSpecCodeIs200)
                .extract().as(LoginResponseModel.class);
    }
}
