package com.narainox.social_media_application.service;

import com.narainox.social_media_application.dto.CreatePostDto;
import com.narainox.social_media_application.dto.PostResponseDto;
import com.narainox.social_media_application.entity.Post;
import com.narainox.social_media_application.entity.User;
import com.narainox.social_media_application.exception.UserNotFoundException;
import com.narainox.social_media_application.repository.PostRepository;
import com.narainox.social_media_application.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    public List<PostResponseDto> getAllPosts(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        List<Post> posts = user.getPosts();
        return posts.stream().map(this::postToPostResponseDto).toList();
    }

    public PostResponseDto createPost(Integer id, CreatePostDto createPostDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        Post post = new Post();
        post.setTitle(createPostDto.getTitle());
        post.setContent(createPostDto.getContent());
        post.setUser(user);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        Post savedPost = postRepository.save(post);
        return postToPostResponseDto(savedPost);
    }
    public PostResponseDto postToPostResponseDto(Post post) {
        return modelMapper.map(post, PostResponseDto.class);
    }
}
