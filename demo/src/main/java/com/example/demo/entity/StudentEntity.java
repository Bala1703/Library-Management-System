package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @Column(name = "id", length = 6)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", length = 50)
    private String name;

    @Column(name = "admission_no", length = 5)
    private String admissionNo;

    @Column(name = "password", length = 64)
    private String password;

    @Column(name = "student_type", length = 30)  // Specify the length according to your needs
    private String studentType;

    // Constructors
    public StudentEntity(String name, String admissionNo, String password, String studentType) {
        this.name = name;
        this.admissionNo = admissionNo;
        this.password = password;
        this.studentType = studentType;
    }

    public StudentEntity() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }
}
