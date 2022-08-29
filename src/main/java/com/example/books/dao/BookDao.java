package com.example.books.dao;

import com.example.books.models.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;


public interface BookDao {

    Collection<Book> getAllBooks();

    Collection<Book> getBooksByName(String name);

    void create(Book book);

}
