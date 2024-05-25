package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.entity.*;
import com.example.demo.repo.*;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class IssueBookService {

    @Autowired
    private IssueBookRepository issueBookRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> issueBook(String admissionNo, String bookId) {
        // Find user by admission number
        Optional<StudentEntity> userOptional = userRepository.findByAdmissionNo(admissionNo);
        if (!userOptional.isPresent()) {
            return ResponseEntity.badRequest().body("User with admission number " + admissionNo + " not found.");
        }
        StudentEntity user = userOptional.get();
        String studentName = user.getName();

        // Find book by book ID
        Optional<BookEntity> bookOptional = bookRepository.findByBookid(bookId);
        if (!bookOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Book with ID " + bookId + " not found.");
        }
        BookEntity book = bookOptional.get();
        String bookName = book.getBookname();

        // Check if the book is available
        if (book.getCopiesAvailable() <= 0) {
            return ResponseEntity.badRequest().body("Book with ID " + bookId + " is not available.");
        }

        // Create an issuance record
        IssueBookEntity issueBook = new IssueBookEntity();
        issueBook.setAdmissionNo(admissionNo);
        issueBook.setStudentname(studentName);
        issueBook.setBookId(bookId);
        issueBook.setBookname(bookName);
        issueBook.setIssueDate(LocalDate.now());

        // Save the issuance record
        issueBookRepository.save(issueBook);

        // Update copiesAvailable in BookEntity
        book.setCopiesAvailable(book.getCopiesAvailable() - 1);
        bookRepository.save(book);

        // Return success response
        return ResponseEntity.ok("Book '" + bookName + "' issued to user '" + studentName + "'.");
    }

    public ResponseEntity<?> returnBook(String admissionNo, String bookId) {
        // Find issued book by admission number and book ID
        Optional<IssueBookEntity> issuedBookOptional = issueBookRepository.findByAdmissionNoAndBookId(admissionNo, bookId)
                .stream()
                .findFirst();

        if (!issuedBookOptional.isPresent()) {
            return ResponseEntity.badRequest().body("No book issued with Admission No: " + admissionNo + " and Book ID: " + bookId);
        }

        // Get the issued book
        IssueBookEntity issuedBook = issuedBookOptional.get();

        // Update return date with current date
        issuedBook.setReturnDate(LocalDate.now().toString());

        // Save the changes
        issueBookRepository.save(issuedBook);

        // Find the book entity to update copiesAvailable
        Optional<BookEntity> bookOptional = bookRepository.findByBookid(bookId);
        if (!bookOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Book with ID " + bookId + " not found in the database.");
        }

        // Get the book entity and update it
        BookEntity book = bookOptional.get();
        book.setCopiesAvailable(book.getCopiesAvailable() + 1);
        bookRepository.save(book);

        return ResponseEntity.ok("Book with ID " + bookId + " returned by user with Admission No: " + admissionNo + ". Copies available updated.");
    }
}
