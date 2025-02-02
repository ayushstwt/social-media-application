package com.narainox.social_media_application.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  Integer id;

    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String gender;
    public LocalDateTime dateOfBirth;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
