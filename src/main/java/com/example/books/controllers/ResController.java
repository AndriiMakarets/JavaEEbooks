package com.example.books.controllers;

import com.example.books.dao.BookDao;
import com.example.books.models.Book;
import com.example.books.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
public class ResController {



    BooksService booksService;

    public ResController(@Qualifier("booksServiceRest") BooksService booksService) {
        this.booksService = booksService;
    }



    @GetMapping(value ="/books")
    public List<Book> bookList () {
        //System.out.println(booksService.getBooks(null).stream().toList().toString());
        return booksService.getBooks(null).stream().toList();

    }

    @GetMapping(value ="/books/{name}")
    public ResponseEntity<Collection<Book>> booksByName (@PathVariable String name) {

        System.out.println(name);
        Collection <Book> response = booksService.getBooks(name).stream().toList();
        if (response.size()!=0) {
            System.out.println("0");
            System.out.println(response);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        }
        else {
            System.out.println("1");
            return ResponseEntity

                    .notFound().build();
        }
    }

    @PostMapping(value = "/add-books")
    public void login(
            @RequestBody final Book book
    ) {
       booksService.addBook(book);
                //ResponseEntity.ok(Book.of(book.getLogin(), "success"));
    }

}
