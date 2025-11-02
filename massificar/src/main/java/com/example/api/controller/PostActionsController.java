package com.example.api.controller;

import com.example.api.model.Comment;
import com.example.api.model.LikeEntity;
import com.example.api.model.Post;
import com.example.api.repository.CommentRepository;
import com.example.api.repository.LikeRepository;
import com.example.api.repository.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostActionsController {
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;
    public PostActionsController(PostRepository postRepository,LikeRepository likeRepository,CommentRepository commentRepository){
        this.postRepository=postRepository;this.likeRepository=likeRepository;this.commentRepository=commentRepository;
    }
    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post){
        return ResponseEntity.ok(postRepository.save(post));
    }
    @PostMapping("/{id}/like")
    public ResponseEntity<LikeEntity> like(@PathVariable Long id,@RequestBody LikeEntity like){
        like.setPostId(id);
        return ResponseEntity.ok(likeRepository.save(like));
    }
    @PostMapping("/{id}/comment")
    public ResponseEntity<Comment> comment(@PathVariable Long id,@RequestBody Comment comment){
        comment.setPostId(id);
        return ResponseEntity.ok(commentRepository.save(comment));
    }
}
