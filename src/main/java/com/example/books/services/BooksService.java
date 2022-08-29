package com.example.books.services;

import com.example.books.models.Book;

import java.util.ArrayList;
import java.util.Collection;

public interface BooksService {
    void addBook (Book book);
    Collection<Book> getBooks(String name);
}
