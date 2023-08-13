package api.tests;

import api.models.LoginBodyModel;
import api.models.LoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import test.TestBase;

import static api.specs.LoginSpec.loginRequestSpec;
import static api.specs.LoginSpec.loginResponseSpecCodeIs200;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginApiTests extends TestBaseApi {
    @Test
    @DisplayName("Successful login API test")
    @Tag("api_tests")
    void successfulLoginApiTest() {
        LoginBodyModel loginData = new LoginBodyModel();
        loginData.setLogin(accountData.getEmail());
        loginData.setPassword(accountData.getPassword());

        LoginResponseModel loginResponse = step("Login request", ()->
                given(loginRequestSpec)
                        .body(loginData)
                        .when()
                        .post("/login")
                        .then()
                        .spec(loginResponseSpecCodeIs200)
                        .extract().as(LoginResponseModel.class));
        step("Check token in not Null", ()->
                assertNotNull(loginResponse.getToken()));
    }
}
