package com.example.books.services;

import com.example.books.dao.BookDao;
import com.example.books.models.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;


@Service
@Getter
@AllArgsConstructor
public class BooksServiceRest implements BooksService{
    BookDao bookDao;

    @Override
    public void addBook(Book book) {
         bookDao.create(book);
    }

    @Override
    public Collection<Book> getBooks(String name) {
        if(name== null)
            return bookDao.getAllBooks();
        return bookDao.getBooksByName(name);
    }
}
