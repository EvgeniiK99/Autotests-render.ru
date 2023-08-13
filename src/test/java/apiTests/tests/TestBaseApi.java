package apiTests.tests;

import apiTests.api.AuthorizationApi;
import apiTests.models.LoginBodyModel;
import config.AccountData;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseApi {

    AuthorizationApi authorizationApi = new AuthorizationApi();
    public static AccountData accountData = ConfigFactory.create(AccountData.class, System.getProperties());
//    LoginBodyModel loginData = new LoginBodyModel();
    public static LoginBodyModel credentials = new LoginBodyModel(accountData.getEmail(), accountData.getPassword());
    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://render.ru/ru";
        RestAssured.basePath = "/v1/user";
    }
}
