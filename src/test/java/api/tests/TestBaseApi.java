package api.tests;

import config.AccountData;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseApi {
    public static AccountData accountData = ConfigFactory.create(AccountData.class, System.getProperties());
    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://render.ru/ru";
        RestAssured.basePath = "/v1/user";
    }
}
