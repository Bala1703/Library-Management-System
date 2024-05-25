package com.example.demo.service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookEntity;
import com.example.demo.repo.BookRepository;

@Service
public class Bookservice {
    @Autowired
    private BookRepository bookRepository;
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        List<BookEntity> books = bookRepository.findAll();
        return ResponseEntity.ok(books);
    }

    public ResponseEntity<?> addBook(BookEntity bookentity){
        if(isBookIDtaken(bookentity.getBookid())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Book number is already taken.");
        }

        BookEntity savebook=bookRepository.save(bookentity);
        return ResponseEntity.ok(savebook);
    }
    public ResponseEntity<?> updateBook(String bookid, BookEntity bookUpdates) {
        Optional<BookEntity> existingBookOpt = bookRepository.findByBookid(bookid);
        if (existingBookOpt.isPresent()) {
            BookEntity existingBook = existingBookOpt.get();
            existingBook.setBookname(bookUpdates.getBookname());
            existingBook.setBookauthor(bookUpdates.getBookauthor());

            BookEntity updatedBook = bookRepository.save(existingBook);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<?> deleteBook(String bookid) {
        Optional<BookEntity> existingBookOpt = bookRepository.findByBookid(bookid);
        if (existingBookOpt.isPresent()) {
            bookRepository.delete(existingBookOpt.get());
            return ResponseEntity.ok("Book deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    private boolean isBookIDtaken(String bookid) {
        Optional<BookEntity> book=bookRepository.findByBookid(bookid);
        return book.isPresent();
    }
}
