package com.example.Users_System.service;

import com.example.Users_System.model.User;
import com.example.Users_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(User user) {
        if (user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null) {
            return "User not created, first name, last name and email are required";
        }
        if (user.getAge() == null) {
            user.setAge(0);
        }
        return userRepository.createUser(user);
    }

    @Override
    public User getUserById(Integer id) {
        if (id == null) {
            System.out.println("It is not possible to accept the user without id");
            return null;
        }
        return userRepository.getUserById(id);
    }

    @Override
    public String updateUser(User user) {
        if (user.getId() == null) {
            return "User not updated, id is required";
        }
        User userBeforeUpdate = userRepository.getUserById(user.getId());
        if (userBeforeUpdate == null) {
            return "The user with this id does not exist, so it cannot be updated";
        }
        if (user.getFirstName() == null) {
            user.setFirstName(userBeforeUpdate.getFirstName());
        }
        if (user.getLastName() == null) {
            user.setLastName(userBeforeUpdate.getLastName());
        }
        if (user.getEmail() == null) {
            user.setEmail(userBeforeUpdate.getEmail());
        }
        if (user.getAge() == null) {
            user.setAge(userBeforeUpdate.getAge());
        }
        if (user.getAddress() == null) {
            user.setAddress(userBeforeUpdate.getAddress());
        }
        if (user.getJoiningDate() == null) {
            user.setJoiningDate(userBeforeUpdate.getJoiningDate());
        }
        return userRepository.updateUser(user);
    }

    @Override
    public String deleteUserById(Integer id) {
        if (id == null) {
            return "It is not possible to delete the user without id";
        }
        User userBeforeDelete = userRepository.getUserById(id);
        if (userBeforeDelete == null) {
            return "The user with this id does not exist, so it cannot be deleted";
        }
        return userRepository.deleteUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
