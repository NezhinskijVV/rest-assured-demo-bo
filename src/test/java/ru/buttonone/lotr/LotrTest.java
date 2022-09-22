package ru.buttonone.lotr;

import io.restassured.response.ValidatableResponse;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.buttonone.model.BookOld;

import java.util.List;

import static io.restassured.RestAssured.given;

@DisplayName("С API властелина колец должны")
public class LotrTest {

    public static final String LOTR_API_URL = "https://the-one-api.dev/v2";

    @DisplayName(" корректно получать книги")
    @Test
    public void shouldHaveCorrectGetBooksTest() {
        ValidatableResponse validatableResponse = given()
                .baseUri(LOTR_API_URL)
                .when()
                .get("/book")
                .then()
                .statusCode(200);

        List<BookOld> bookOldList = validatableResponse
                .extract()
                .body()
                .jsonPath().getList("docs", BookOld.class);

        System.out.println(bookOldList);

        //1
//        Assertions.assertAll(
////                () -> assertTrue(bookList.stream().anyMatch(b -> b.getName().equals("The Fellowship Of The Ring")))
//        );


//        assertThat(bookList, hasItem(new Book("The Fellowship Of The Ring")));


        MatcherAssert.assertThat(bookOldList, Matchers.containsInAnyOrder(new BookOld("The Fellowship Of The Ring"),
                new BookOld("The Return Of The King"),
                new BookOld("The Two Towers")
        ));


//                .log().all()
//                .statusCode(200);

    }


}