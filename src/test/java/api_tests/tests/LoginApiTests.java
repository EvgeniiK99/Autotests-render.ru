package api_tests.tests;

import api_tests.api.AuthorizationApi;
import api_tests.models.ErrorLoginResponseModel;
import api_tests.models.LoginBodyModel;
import api_tests.models.LoginResponseModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api_tests.specs.BaseSpec.baseResponseSpecCodeIs401;
import static api_tests.specs.LoginSpec.*;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Epic("API_Tests")
@Feature("Authorization")
public class LoginApiTests extends TestBaseApi {
    @Test
    @DisplayName("Successful login API test")
    @Owner("Evgenii Klimashin")
    @Severity(BLOCKER)
    @Tag("api_tests")
    void successfulLoginApiTest() {
        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);

        step("Check token is not Null", ()->
                assertNotNull(loginResponse.getToken()));
    }

    @Test
    @DisplayName("Authentication Failed API test")
    @Owner("Evgenii Klimashin")
    @Severity(BLOCKER)
    @Tag("api_tests")
    void unsuccessfulLoginApiTest() {
        ErrorLoginResponseModel errorLoginResponse = step("Send request", ()->
             given(loginRequestSpec)
                .body(new LoginBodyModel(accountData.getEmail(), null))
                .when()
                .post("/login")
                .then()
                .spec(baseResponseSpecCodeIs401)
                .extract().as(ErrorLoginResponseModel.class));

        step("Check error message", ()->
                assertEquals("Incorrect authentication credentials." ,errorLoginResponse.getDetails().get(0).getText()));
    }
}
