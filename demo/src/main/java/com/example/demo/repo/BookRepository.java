package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BookEntity;;
public interface BookRepository extends JpaRepository<BookEntity,Long> {

    Optional<BookEntity> findByBookid(String bookid);
    
}
