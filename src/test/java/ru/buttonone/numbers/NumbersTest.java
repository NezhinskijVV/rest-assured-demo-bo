package ru.buttonone.numbers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class NumbersTest {
    public static final String NUMBERS_URL = "http://numbersapi.com";

    @Test
    public void shouldHaveCorrectGet2() {
//        Response response = RestAssured.given().get("http://numbersapi.com/2");
////        response.prettyPrint();
////        System.out.println(response.statusCode());
//        Assertions.assertEquals(200, response.statusCode());

        given()
                .header(new Header("Accept-Language", "ru"))
                .baseUri(NUMBERS_URL)
                .when()
                .get("/2")
                .then()
                .contentType(ContentType.TEXT)
                .log().all()
                .header("Content-Length", "67")
                .statusCode(200);

    }
}

//given when then (Gherkin)