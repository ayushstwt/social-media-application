package com.narainox.social_media_application.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserResponseDto {
    public Integer id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String gender;
    private LocalDateTime dateOfBirth;
}
