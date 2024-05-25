package com.example.demo.repo;

import com.example.demo.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<StudentEntity, Long> {
    Optional<StudentEntity> findByAdmissionNo(String admissionNo);
    Optional<StudentEntity> findByStudentType(String studentType);
}
