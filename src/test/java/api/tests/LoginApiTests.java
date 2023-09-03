package api.tests;

import api.api_requests.AuthorizationApi;
import api.models.ErrorLoginResponseModel;
import api.models.LoginBodyModel;
import api.models.LoginResponseModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.specs.BaseSpec.baseRequestWithJsonBodySpec;
import static api.specs.BaseSpec.baseResponseSpecCodeIs401;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.*;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Owner("Evgenii Klimashin")
@Severity(BLOCKER)
@Tag("api")
@Epic("API_Tests")
@Feature("Authorization")
public class LoginApiTests extends TestBaseApi {

    @Test
    @DisplayName("Successful login API test")
    void successfulLoginApiTest() {
        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);

        step("Check token is not Null", () ->
                assertNotNull(loginResponse.getToken()));
    }

    @Test
    @DisplayName("Authentication Failed API test")
    void unsuccessfulLoginApiTest() {
        ErrorLoginResponseModel errorLoginResponse = step("Send request", () ->
                given(baseRequestWithJsonBodySpec)
                        .body(new LoginBodyModel(accountData.getEmail(), null))
                        .when()
                        .post("/user/login")
                        .then()
                        .spec(baseResponseSpecCodeIs401)
                        .extract().as(ErrorLoginResponseModel.class));

        step("Check error message", () ->
                assertEquals("Incorrect authentication credentials.", errorLoginResponse.getDetails().get(0).getText()));
    }
}
