package com.example.books.models;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class Book {
    //@NotNull
    private String name;
   // @NotNull
    private String isbn;
    //@NotNull
    private String author;
}
