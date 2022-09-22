package ru.buttonone.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
    private String id;
    private String authors;
    private String genre;
    private String title;

}
