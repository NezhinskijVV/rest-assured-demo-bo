package ru.buttonone.numbers;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.buttonone.numbers.specification.NumbersSpecifications;

import static io.restassured.RestAssured.given;
import static ru.buttonone.numbers.specification.NumbersSpecifications.defaultRequestSpecification;


public class NumbersTest {
    public static final String NUMBERS_URI = "http://numbersapi.com";
    public static final String ID_PATH = "/{id}";


    @Test
    public void shouldHaveCorrectGet2() {
//        Response response = RestAssured.given().get("http://numbersapi.com/2");
////        response.prettyPrint();
////        System.out.println(response.statusCode());
//        Assertions.assertEquals(200, response.statusCode());

//        RequestSpecification requestSpecification
//                = new RequestSpecBuilder()
//                .addHeader("Accept-Language", "ru")
//                .setBaseUri(NUMBERS_URL)
//                .build();

        ResponseSpecification responseSpecification
                = new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(200)
                .build();


        given()
                .baseUri(NUMBERS_URI)
                .pathParam("id", 2)
                .when()
                .get(ID_PATH)
                .then()
                .log().all()
                .statusCode(200);

    }
}

//given when then (Gherkin)

//1. Выучить что такое BDD
//2. Создать свои кастомные спецификации в отдельном классе
// и добавить в каждый тест (возможно туда засунуть общие константы)
//3. Написать тесты с негативными сценариями