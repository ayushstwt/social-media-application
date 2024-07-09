package com.narainox.social_media_application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String firstName;
    public String lastName;
    public  Integer id;
    public String email;
    public String password;
    public String gender;
    public LocalDateTime dateOfBirth;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
