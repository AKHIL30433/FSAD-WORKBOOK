package com.klu.service;



import java.util.*;
import org.springframework.stereotype.Service;

import com.klu.entity.Book;
import com.klu.repository.BookRepository;




@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public void addBook(Book book) {
        repo.save(book);
    }

    public List<Book> getBooks() {
        return repo.findAll();
    }
}