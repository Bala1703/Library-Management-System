package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repo.UserRepository;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Use PasswordEncoder for password verification

    /**
     * Method to handle login functionality
     * 
     * @param admissionNo The admission number provided by the user
     * @param password The password provided by the user
     * @return ResponseEntity indicating the outcome of the login attempt
     */
    public ResponseEntity<?> login(String admissionNo, String password) {
        // Attempt to find a student by their admission number
        Optional<StudentEntity> optionalStudent = userRepository.findByAdmissionNo(admissionNo);
        
        if (!optionalStudent.isPresent()) {
            // If no student is found with the given admission number, return a bad request
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Admission number does not exist.");
        }

        // If a student is found, retrieve the student
        StudentEntity student = optionalStudent.get();

        // Check if the provided password matches the stored hashed password
        if (!passwordEncoder.matches(password, student.getPassword())) {
            // If the password does not match, return an unauthorized status
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid password.");
        }

        // If the password matches, login is successful
        return ResponseEntity.ok("Login successful!");
    }
}
