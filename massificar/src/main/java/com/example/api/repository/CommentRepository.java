package com.example.api.repository;

import com.example.api.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CommentRepository extends JpaRepository<Comment,Long>{}
