package ru.buttonone.library;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.buttonone.model.Book;
import ru.buttonone.repository.BookRepository;

import java.util.List;

@SpringBootTest //поднимается весь контекст
public class LibraryTest {

    @Autowired //внедрение
    private BookRepository bookRepository;

    @DisplayName("после добавления книга появляется в БД")
    @Test
    public void shouldHaveCorrectEntityInDbAfterAddingBook() throws JsonProcessingException {
        Book expectedBook = new Book("100", "a100", "g100", "t100");
        //expectedBook -> json
        String jsonExpectedBook = new ObjectMapper().writerWithDefaultPrettyPrinter()
                .writeValueAsString(expectedBook);

        RestAssured.given()
                .baseUri("http://localhost:8080")
                .header(new Header("Content-Type", "application/json"))
                .body(jsonExpectedBook)
                .when()
                .post("/api/books/add")
                .then()
                .statusCode(200);

        Book firstBook = bookRepository.getBooksByTitle("t100").get(0);

        Assertions.assertAll(
                () -> Assertions.assertEquals("a100", firstBook.getAuthors()),
                () -> Assertions.assertEquals("g100", firstBook.getGenre()),
                () -> Assertions.assertEquals("t100", firstBook.getTitle())
        );
    }


}
