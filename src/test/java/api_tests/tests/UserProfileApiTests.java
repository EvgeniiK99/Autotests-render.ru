package api_tests.tests;

import api_tests.api.AuthorizationApi;
import api_tests.models.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api_tests.specs.BaseSpec.baseRequestWithJsonBodySpec;
import static api_tests.specs.BaseSpec.baseResponseSpecCodeIs200;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Owner("Evgenii Klimashin")
@Severity(CRITICAL)
@Epic("API_Tests")
@Feature("User profile")
public class UserProfileApiTests extends TestBaseApi {

    @Test
    @DisplayName("Successful change user info")
    @Tag("api_tests")
    void successfulChangeUserInfoApiTest() {
        String ruText = "Привет! Я тестовый юзер!";
        String enText = "Hello! I'm test user!";
        LoginResponseModel loginResponse = AuthorizationApi.login(credentials);

        UserProfileResponseModel userProfileResponse = step("Send request", () ->
                given(baseRequestWithJsonBodySpec)
                        .header("Cookie", "xf_user=" + loginResponse.getToken())
                        .body(new UserProfileBodyModel(
                                new UserProfileBodyModel.Detail(ruText,
                                        new UserProfileBodyModel.Detail.EnglishDetails(enText))))
                        .when()
                        .post("/about/artist/255646")
                        .then()
                        .spec(baseResponseSpecCodeIs200)
                        .extract().as(UserProfileResponseModel.class));

        step("Check text in response", () ->
                assertEquals(ruText, userProfileResponse.getResume().getAbout()));
        assertEquals(enText, userProfileResponse.getResume().getEn().getAbout());
    }
}
