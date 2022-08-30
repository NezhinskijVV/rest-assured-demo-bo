package ru.buttonone.numbers.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class NumbersSpecifications {

    public static final String NUMBERS_URL = "http://numbersapi.com/2";

    public static RequestSpecification defaultRequestSpecification() {

        return new RequestSpecBuilder()
                .addHeader("Accept-Language", "fr")
                .setBaseUri(NUMBERS_URL)
                .log(LogDetail.ALL)
                .build();
    }

}
