package com.narainox.social_media_application.repository;

import com.narainox.social_media_application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
