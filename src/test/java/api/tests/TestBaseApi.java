package api.tests;

import api.models.LoginBodyModel;
import config.AccountData;
import config.WebDriverConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseApi {

    public static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    public static AccountData accountData = ConfigFactory.create(AccountData.class, System.getProperties());
    public static LoginBodyModel credentials = new LoginBodyModel(accountData.getEmail(), accountData.getPassword());

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = config.getBaseUrl();
        RestAssured.basePath = config.getBasePath();
    }
}
