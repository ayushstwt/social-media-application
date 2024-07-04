package com.narainox.social_media_application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CreateUserDto {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String gender;
}
