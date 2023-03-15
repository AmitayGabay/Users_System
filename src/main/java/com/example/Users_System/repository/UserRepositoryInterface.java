package com.example.Users_System.repository;

import com.example.Users_System.model.User;

import java.util.List;

public interface UserRepositoryInterface {
    String createUser(User user);

    User getUserById(Integer id);

    String updateUser(User user);

    String deleteUserById(Integer id);

    List<User> getAllUsers();
}
