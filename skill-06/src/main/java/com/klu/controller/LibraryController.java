package com.klu.controller;



import org.springframework.web.bind.annotation.*;

import com.klu.entity.Book;

import java.util.*;


@RestController
@RequestMapping("/library")
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System!";
    }

    @GetMapping("/count")
    public int getCount() {
        return 100;
    }

    @GetMapping("/price")
    public double getPrice() {
        return 499.99;
    }

    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Java Basics", "Spring Boot Guide", "DSA");
    }

    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book ID: " + id;
    }

    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "Searching for: " + title;
    }

    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Author: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added!";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}