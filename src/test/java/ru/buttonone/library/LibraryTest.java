package ru.buttonone.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.buttonone.repository.BookRepository;

@SpringBootTest //поднимается весь контекст
public class LibraryTest {

    @Autowired //внедрение
    private BookRepository bookRepository;

    @Test
    public void shouldHaveCorrectEntityInDbAfterAddingBook(){

        System.out.println(bookRepository.getBooksByTitle("t1"));


    }


}
