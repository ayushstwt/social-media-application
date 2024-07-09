package com.narainox.social_media_application.service;

import com.narainox.social_media_application.dto.CreateUserDto;
import com.narainox.social_media_application.dto.UpdateUserDto;
import com.narainox.social_media_application.dto.UserResponseDto;
import com.narainox.social_media_application.entity.User;
import com.narainox.social_media_application.exception.UserNotFoundException;
import com.narainox.social_media_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> userResponseDtos = users.stream().map(user -> {
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setFirstName(user.getFirstName());
            userResponseDto.setEmail(user.getEmail());
            userResponseDto.setPassword(user.getPassword());
            userResponseDto.setLastName(user.getLastName());
            userResponseDto.setGender(user.getGender());
            return userResponseDto;
        }).toList();
        return userResponseDtos;
    }

    public UserResponseDto createUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setEmail(createUserDto.getEmail());
        user.setGender(createUserDto.getGender());
        user.setPassword(createUserDto.getPassword());
        User savedUser = userRepository.save(user);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setFirstName(savedUser.getFirstName());
        userResponseDto.setEmail(savedUser.getEmail());
        userResponseDto.setPassword(savedUser.getPassword());
        userResponseDto.setLastName(savedUser.getLastName());
        userResponseDto.setGender(savedUser.getGender());
        return userResponseDto;
    }

    public UserResponseDto getUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        UserResponseDto userResponseDto=new UserResponseDto();
        userResponseDto.setFirstName(user.getFirstName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        userResponseDto.setLastName(user.getLastName());
        userResponseDto.setGender(user.getGender());
        return userResponseDto;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public UserResponseDto updateUser(UpdateUserDto updateUserDto) {
        User user = userRepository.findById(updateUserDto.getId()).orElseThrow(() -> new UserNotFoundException("User not found with id: " + updateUserDto.getId()));
        user.setFirstName(updateUserDto.getFirstName());
        user.setLastName(updateUserDto.getLastName());
        user.setEmail(updateUserDto.getEmail());
        user.setGender(updateUserDto.getGender());
        user.setPassword(updateUserDto.getPassword());
        User savedUser = userRepository.save(user);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setFirstName(savedUser.getFirstName());
        userResponseDto.setEmail(savedUser.getEmail());
        userResponseDto.setPassword(savedUser.getPassword());
        userResponseDto.setLastName(savedUser.getLastName());
        userResponseDto.setGender(savedUser.getGender());
        userResponseDto.setId(savedUser.getId());
        return userResponseDto;
    }
}
