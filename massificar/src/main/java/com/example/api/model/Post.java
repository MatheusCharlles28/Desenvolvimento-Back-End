package com.example.api.model;

import jakarta.persistence.*;
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getContent(){return content;}
    public void setContent(String content){this.content=content;}
}
