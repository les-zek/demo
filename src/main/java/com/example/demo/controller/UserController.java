package com.example.demo.controller;


import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dtos.CreateUserDto;
import com.example.demo.model.dtos.UpdateUserDto;
import com.example.demo.model.dtos.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;  // DB -> User  FE -> Dto

    @GetMapping("/users")
    public List<UserDto> getUsers(){
        return userMapper.toDtos(userService.getUsers());
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser (@PathVariable("userId") long userId) {
        return userMapper.toDto(userService.getUser(userId));
    }

    @PostMapping("/addUser")
    public void createUser (CreateUserDto createUserDto) {
    userService.createUser(userMapper.fromDto(createUserDto));
    }


    @PutMapping("/updateUser")
    public void updateUser(UpdateUserDto updateUserDto) {
    userService.updateUser(userMapper.fromDto(updateUserDto));
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser(@PathVariable("userId") long userId) {
        userService.deleteUser(userId);
    }
}
