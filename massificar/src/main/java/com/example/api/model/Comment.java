package com.example.api.model;

import jakarta.persistence.*;
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private Long userId;
    private String text;
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Long getPostId(){return postId;}
    public void setPostId(Long postId){this.postId=postId;}
    public Long getUserId(){return userId;}
    public void setUserId(Long userId){this.userId=userId;}
    public String getText(){return text;}
    public void setText(String text){this.text=text;}
}
