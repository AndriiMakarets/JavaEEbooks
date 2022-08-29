package com.example.books.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor(staticName = "of")
public class Book {
    //@NotNull
    private String name;
   // @NotNull
    private String isbn;
    //@NotNull
    private String author;
}
