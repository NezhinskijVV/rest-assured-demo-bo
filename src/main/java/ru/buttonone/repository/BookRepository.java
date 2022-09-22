package ru.buttonone.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import ru.buttonone.model.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("select id, title from books")
    List<Book> getBooksByTitle(String title);
}
