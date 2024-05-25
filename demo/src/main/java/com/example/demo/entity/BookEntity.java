package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @Column(name = "id", length = 6)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Bookid", length = 6)
    private String bookid;

    @Column(name = "Bookname", length = 50)
    private String bookname;

    @Column(name = "BookAuthor", length = 50)
    private String bookauthor;

    @Column(name = "TotalCopies")
    private int totalCopies;

    @Column(name = "CopiesAvailable")
    private int copiesAvailable;

    public BookEntity() {
    }

    public BookEntity(String bookid, String bookname, String bookauthor, int totalCopies,int copiesAvailable) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.totalCopies = totalCopies;                     
        this.copiesAvailable = copiesAvailable;  
    }
    
    public long getId() {
        return id;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookauthor() {
        return bookauthor;
    }

    public void setBookauthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }
}
