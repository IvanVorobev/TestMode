package ru.netology.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class DataGenerator {

    private static RequestSpecification specification = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(7777)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static void requestForm(Registration registration) {
        given()
                .spec(specification)
                .body(registration)
                .when()
                .post("/api/system/users")
                .then()
                .statusCode(200);
    }
}

