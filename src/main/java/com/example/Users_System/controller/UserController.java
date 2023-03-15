package com.example.Users_System.controller;

import com.example.Users_System.external_api.PollsSystemService;
import com.example.Users_System.model.AnswerRequest;
import com.example.Users_System.model.User;
import com.example.Users_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    PollsSystemService pollsSystemService;

    @PostMapping(value = "/create")
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping(params = "id")
    public User getUserById(@RequestParam Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping(value = "/update")
    public String updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(value = "/delete", params = "id")
    public String deleteUser(@RequestParam Integer id) {
        return userService.deleteUserById(id);
    }

    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/answer-the-question")
    public String answerTheQuestion(@RequestBody AnswerRequest answerRequest) {
        return pollsSystemService.answerTheQuestion(answerRequest);
    }

    @GetMapping(value = "/numbers-of-answers-per-user", params = "id")
    public Integer getNumberOfAnswersPerUser(@RequestParam Integer id) {
        return pollsSystemService.getNumberOfAnswersPerUser(id);
    }

    @GetMapping(value = "/user-answers-to-each-question-he-submitted", params = "id")
    public String getUserAnswersToEachQuestionHeSubmitted(@RequestParam Integer id) {
        return pollsSystemService.getUserAnswersToEachQuestionHeSubmitted(id);
    }
}
