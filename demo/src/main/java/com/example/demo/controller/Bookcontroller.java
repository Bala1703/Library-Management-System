package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.BookEntity;
import com.example.demo.service.Bookservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class Bookcontroller {
    
    @Autowired
    private Bookservice bookservice;

    @PostMapping("/addbook")
    public ResponseEntity<?> addBook(@RequestBody BookEntity bookEntity) {
        ResponseEntity<?> response = bookservice.addBook(bookEntity);
        return response;
    }

    @PutMapping("/updatebook/{bookid}")
    public ResponseEntity<?> updateBook(@PathVariable String bookid, @RequestBody BookEntity bookEntity) {
        ResponseEntity<?> response = bookservice.updateBook(bookid, bookEntity);
        return response;
    }

    @DeleteMapping("/deletebook/{bookid}")
    public ResponseEntity<?> deleteBook(@PathVariable String bookid) {
        ResponseEntity<?> response = bookservice.deleteBook(bookid);
        return response;
    }

    @GetMapping("/getbooks")
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        return bookservice.getAllBooks();
    }
}
