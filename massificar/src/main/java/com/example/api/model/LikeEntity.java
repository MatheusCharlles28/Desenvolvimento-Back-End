package com.example.api.model;

import jakarta.persistence.*;
@Entity
@Table(name = "post_like")
public class LikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private Long userId;
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Long getPostId(){return postId;}
    public void setPostId(Long postId){this.postId=postId;}
    public Long getUserId(){return userId;}
    public void setUserId(Long userId){this.userId=userId;}
}
