package com.example.api.model;

import jakarta.persistence.*;
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentId;
    private String subject;
    private Double score;
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Long getStudentId(){return studentId;}
    public void setStudentId(Long studentId){this.studentId=studentId;}
    public String getSubject(){return subject;}
    public void setSubject(String subject){this.subject=subject;}
    public Double getScore(){return score;}
    public void setScore(Double score){this.score=score;}
}
