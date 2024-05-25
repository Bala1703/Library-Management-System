package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "issued_books")
public class IssueBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admission_no")
    private String admissionNo;

    @Column(name = "book_id")
    private String bookId;

    @Column(name="Student_name")
    private String studentname;

    @Column(name="book_name")
    private String bookname;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "return_date")
    private String returnDate = "-";

    public IssueBookEntity() {}

    public IssueBookEntity(String admissionNo, String bookId, String studentname, String bookname, LocalDate issueDate) {
        this.admissionNo = admissionNo;
        this.bookId = bookId;
        this.studentname = studentname;
        this.bookname = bookname;
        this.issueDate = issueDate;
    }

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

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate localDate) {
        this.issueDate = localDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

}
