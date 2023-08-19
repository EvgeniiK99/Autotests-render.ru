package api_tests.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static api_tests.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.*;

public class LoginSpec {
    public static RequestSpecification loginRequestSpec = with()
            .log().uri()
            .log().method()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(JSON);
    public static ResponseSpecification loginResponseSpecCodeIs200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();
}
