package apiTests.tests;

import apiTests.models.LoginBodyModel;
import apiTests.models.LoginResponseModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginApiTests extends TestBaseApi {
    @Test
    @DisplayName("Successful login API test")
    @Tag("api_tests")
    void successfulLoginApiTest() {
//        loginData.setLogin(accountData.getEmail());
//        loginData.setPassword(accountData.getPassword());

        LoginResponseModel loginResponse = authorizationApi.login(credentials);
        step("Check token in not Null", ()->
                assertNotNull(loginResponse.getToken()));
    }
}
