package com.example.books.controllers;

import com.example.books.models.Book;
import com.example.books.services.BooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    BooksService booksService;

    public BookController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping(value ="/books-list")
    public String bookList (Model model){
           model.addAttribute("books",booksService.getBooks());
           return "all-books";
        }


    @PostMapping(value ="/add-book")
    public String addNewBook(@ModelAttribute Book book){
        booksService.addBook(book);
        return "redirect:/books-list";
    }

    @GetMapping(value ="/add-book")
    public String root(@ModelAttribute Book book){
        return "create";
    }
}
