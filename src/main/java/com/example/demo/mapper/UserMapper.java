package com.example.demo.mapper;


import com.example.demo.model.User;
import com.example.demo.model.dtos.CreateUserDto;
import com.example.demo.model.dtos.UpdateUserDto;
import com.example.demo.model.dtos.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    // mapowanie encji na obiekt DTO
    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName());
    }

    // mapowanie listy obiektow User na liste DTO
    public List<UserDto> toDtos(List<User> users) {
        return users.stream().map(user -> toDto(user)).collect(Collectors.toList());

    }

    // mapowanie obiektu CreateUserDto na user
    public User fromDto(CreateUserDto createUserDto) {
        User user = new User();
        user.setName(createUserDto.getName());
        return user;
    }

    // mapowanie obiektu UpdateUserDto na User
    public User fromDto(UpdateUserDto updateUserDto) {
        return new User(updateUserDto.getId(), updateUserDto.getName());
    }

}
