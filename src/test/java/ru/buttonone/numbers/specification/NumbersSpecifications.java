package ru.buttonone.numbers.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class NumbersSpecifications {

    public static final String NUMBERS_URI = "http://numbersapi.com";

    public static RequestSpecification defaultRequestSpecification() {

        return new RequestSpecBuilder()
                .addHeader("Accept-Language", "fr")
                .setBaseUri(NUMBERS_URI)
                .log(LogDetail.ALL)
                .build();
    }

}
