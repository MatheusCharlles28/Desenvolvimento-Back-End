package com.example.api.model;

import jakarta.persistence.*;
@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentId;
    private String courseCode;
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Long getStudentId(){return studentId;}
    public void setStudentId(Long studentId){this.studentId=studentId;}
    public String getCourseCode(){return courseCode;}
    public void setCourseCode(String courseCode){this.courseCode=courseCode;}
}
