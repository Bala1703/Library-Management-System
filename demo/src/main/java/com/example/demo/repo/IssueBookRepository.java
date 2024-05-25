package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.IssueBookEntity;

public interface IssueBookRepository extends JpaRepository<IssueBookEntity,Long> {

    Optional<IssueBookEntity> findByAdmissionNoAndBookId(String admissionNo, String bookId);


}
