package com.example.books.dao;

import com.example.books.models.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;


@Repository
public class InMemoryBookDao implements BookDao{

    private ArrayList<Book> library;

    public InMemoryBookDao(ArrayList<Book> library) {
        this.library = library;
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        return library;
    }

    @Override
    public ArrayList<Book> getBooksByName(String name) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book: library) {
            if(book.getName().contains(name))
                result.add(book);
        }
        return result;
    }

    @Override
    public void create(Book book) {
        library.add(book);
    }
}
