package com.narainox.social_media_application.repository;

import com.narainox.social_media_application.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
