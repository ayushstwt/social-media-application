package com.narainox.social_media_application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateUserDto {
    @Size(min=3, message="First name should have at least 2 characters")
    public String firstName;
    @Size(min=3, message="Last name should have at least 2 characters")
    public String lastName;
    @Email(message = "Email should be valid")
    public String email;
    public String password;
    public String gender;
    @Past
    public LocalDateTime dateOfBirth;
}
