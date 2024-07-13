package com.narainox.social_media_application.controller;

import com.narainox.social_media_application.dto.CreatePostDto;
import com.narainox.social_media_application.handler.ResponseHandler;
import com.narainox.social_media_application.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<Object> getAllPosts(@PathVariable Integer id)
    {
        return ResponseHandler.generateResponse("post retrieved successfully", HttpStatus.OK,postService.getAllPosts(id));
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable Integer id, @Valid @RequestBody CreatePostDto createPostDto)
    {
        return ResponseHandler.generateResponse("post created successfully", HttpStatus.OK,postService.createPost(id,createPostDto));
    }
}
