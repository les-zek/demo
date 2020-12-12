package com.example.demo.service;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {

        return userRepository.findAll();
    }

    public User getUser(long id) {
        Optional<User> isUser = userRepository.findById(id);
// zwraca pobrany obiekt user gdy wystepuje
        // lub nowa instancje gdy id nie ma
        return isUser.orElseGet(() -> new User(0, "B/D"));
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(long id) {
        Optional<User> isUser = userRepository.findById(id);
        isUser.ifPresent(user -> userRepository.delete(user));

    }

}
