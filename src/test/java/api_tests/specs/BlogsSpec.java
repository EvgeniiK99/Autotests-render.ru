package api_tests.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static api_tests.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class BlogsSpec {
    public static RequestSpecification addBlogToFavoriteRequestSpec = with()
            .log().uri()
            .log().method()
            .log().body()
            .filter(withCustomTemplates());
    public static ResponseSpecification addBlogToFavoriteResponseSpecCodeIs200 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();
}
