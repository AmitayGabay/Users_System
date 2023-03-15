package com.example.Users_System.service;

import com.example.Users_System.model.User;

import java.util.List;

public interface UserServiceInterface {
    String createUser(User user);

    User getUserById(Integer id);

    String updateUser(User user);

    String deleteUserById(Integer id);

    List<User> getAllUsers();
}
