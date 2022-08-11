package com.example.books.services;

import com.example.books.models.Book;

import java.util.ArrayList;

public interface BooksService {
    void addBook (Book book);
    ArrayList<Book> getBooks();
}
