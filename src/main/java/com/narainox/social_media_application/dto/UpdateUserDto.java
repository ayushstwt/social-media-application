package com.narainox.social_media_application.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UpdateUserDto {
    public Integer id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String gender;
}
