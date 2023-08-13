package apiTests.api;

import apiTests.models.LoginBodyModel;
import apiTests.models.LoginResponseModel;
import apiTests.tests.TestBaseApi;
import io.qameta.allure.Step;

import static apiTests.specs.LoginSpec.loginRequestSpec;
import static apiTests.specs.LoginSpec.loginResponseSpecCodeIs200;
import static io.restassured.RestAssured.given;

public class AuthorizationApi{

    @Step("Login request")
    public LoginResponseModel login(LoginBodyModel loginData) {
        return given(loginRequestSpec)
                .body(loginData)
                .when()
                .post("/login")
                .then()
                .spec(loginResponseSpecCodeIs200)
                .extract().as(LoginResponseModel.class);
    }
}
