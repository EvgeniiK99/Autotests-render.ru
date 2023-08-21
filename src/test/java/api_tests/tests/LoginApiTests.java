package api_tests.tests;

import api_tests.api.AuthorizationApi;
import api_tests.models.LoginResponseModel;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Epic("API_Tests")
@Feature("Authorizations")
public class LoginApiTests extends TestBaseApi {
    @Test
    @DisplayName("Successful login API test")
    @Tag("api_tests")
    void successfulLoginApiTest() {

        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);
        step("Check token in not Null", ()->
                assertNotNull(loginResponse.getToken()));
    }
}
