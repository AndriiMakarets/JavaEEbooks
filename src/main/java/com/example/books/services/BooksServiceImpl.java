package com.example.books.services;

import com.example.books.models.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Getter
@AllArgsConstructor
public class BooksServiceImpl  implements BooksService{
    private ArrayList<Book> library;

    @Override
    public void addBook(Book book) {
        library.add(book); //use repository
    }

    @Override
    public ArrayList<Book> getBooks(String name) {
        return getLibrary();
    }
}
