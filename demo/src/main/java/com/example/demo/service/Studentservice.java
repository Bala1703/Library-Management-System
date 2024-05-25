package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder; // Import PasswordEncoder
import org.springframework.stereotype.Service;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repo.UserRepository;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Studentservice {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Autowire PasswordEncoder

    public ResponseEntity<?> addStudent(StudentEntity student) {
        // Check if student type is admin
        if ("Admin".equalsIgnoreCase(student.getStudentType().trim())) {
            // Check if an admin already exists
            Optional<StudentEntity> existingAdmin = userRepository.findByStudentType("Admin");
            if (existingAdmin.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Admin account already exists.");
            }
        }

        // Check if admission number already exists
        if (isAdmissionNoTaken(student.getAdmissionNo())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Admission number already taken.");
        }

        // Validate password
        if (!isPasswordValid(student.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Password must contain at least 1 uppercase letter, " +
                          "1 special symbol, 1 number, and lowercase letters.");
        }

        // Hash the password
        String hashedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(hashedPassword); // Set the hashed password

        // Save student if password is valid
        StudentEntity savedStudent = userRepository.save(student);
        return ResponseEntity.ok(savedStudent);
    }

    // Method to validate password
    private boolean isPasswordValid(String password) {
        // Regex to validate password
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    // Method to check if admission number already exists
    private boolean isAdmissionNoTaken(String admissionNo) {
        Optional<StudentEntity> existingStudent = userRepository.findByAdmissionNo(admissionNo);
        return existingStudent.isPresent();
    }
}
