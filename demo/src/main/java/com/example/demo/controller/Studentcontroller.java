package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.LoginService;
import com.example.demo.service.Studentservice;

@RestController
@RequestMapping("/api/users")
public class Studentcontroller {
    @Autowired
    private Studentservice studentService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/signup")
    public ResponseEntity<?> addStudent(@RequestBody StudentEntity student) {
        // Call the service method to add student
        ResponseEntity<?> response = studentService.addStudent(student);
        return response;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody StudentLoginRequest loginRequest) {
        ResponseEntity<?> loginResponse = loginService.login(loginRequest.getAdmissionNo(), loginRequest.getPassword());
        return loginResponse;
    }

    public static class StudentLoginRequest {
        private String admissionNo;
        private String password;    

        public String getAdmissionNo() {
            return admissionNo;
        }

        public void setAdmissionNo(String admissionNo) {
            this.admissionNo = admissionNo;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
