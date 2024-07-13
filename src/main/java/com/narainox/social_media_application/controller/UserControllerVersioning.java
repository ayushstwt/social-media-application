package com.narainox.social_media_application.controller;


import com.narainox.social_media_application.dto.UserResponseDto;
import com.narainox.social_media_application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerVersioning {
    @Autowired
    private UserService userService;

    //versioning with URL
    @GetMapping("/v1/users")
    public List<UserResponseDto> getAllUsers()
    {
        return  userService.getAllUsers();
    }

    //versioning with request parameter
    @GetMapping(path = "/users",params = "version=1")
    public List<UserResponseDto> getAllUser()
    {
        return  userService.getAllUsers();
    }

    //Header versioning
    @GetMapping(path = "/users/header",headers = "X-API-VERSION=1")
    public List<UserResponseDto> getUsers()
    {
        return  userService.getAllUsers();
    }

    //Media Type versioning accept headers
    @GetMapping(path = "/users/header",produces = "application/narainox.company.app-V1+json")
    public List<UserResponseDto> getUserList()
    {
        return  userService.getAllUsers();
    }

}
