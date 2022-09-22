package ru.buttonone.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@Data
public class BookOld {
    @JsonProperty("_id")
    private String id;
    private String name;

    public BookOld(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookOld)) return false;
        BookOld bookOld = (BookOld) o;
        return name.equals(bookOld.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}