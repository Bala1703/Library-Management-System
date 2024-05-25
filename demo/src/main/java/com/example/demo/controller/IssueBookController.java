package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.IssueBookService;

@RestController
@RequestMapping("/api/issue-books")
public class IssueBookController {

    @Autowired
    private IssueBookService issueBookService;
    
    @PostMapping("/issue")
    public ResponseEntity<?> issueBook(@RequestBody IssueBookRequest request) {
        return issueBookService.issueBook(request.getAdmissionNo(), request.getBookId());
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnBook(@RequestBody IssueBookRequest request) {
        return issueBookService.returnBook(request.getAdmissionNo(), request.getBookId());
    }

    public static class IssueBookRequest {
        private String admissionNo;
        private String bookId;

        // Getters and setters
        public String getAdmissionNo() {
            return admissionNo;
        }

        public void setAdmissionNo(String admissionNo) {
            this.admissionNo = admissionNo;
        }

        public String getBookId() {
            return bookId;
        }

        public void setBookId(String bookId) {
            this.bookId = bookId;
        }
    }
}
