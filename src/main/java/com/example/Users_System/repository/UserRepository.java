package com.example.Users_System.repository;

import com.example.Users_System.external_api.PollsSystemService;
import com.example.Users_System.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserRepositoryInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PollsSystemService pollsSystemService;

    private static final String USER_TABLE = "user";

    @Override
    public String createUser(User user) {
        try {
            String sql = String.format("INSERT INTO %s (first_name, last_name, email, age, address, joining_date) VALUES (?,?,?,?,?,?)", USER_TABLE);
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(), user.getAddress(), user.getJoiningDate());
            return "User created successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public User getUserById(Integer id) {
        try {
            String sql = String.format("SELECT * FROM %s WHERE id = ?", USER_TABLE);
            User user = jdbcTemplate.queryForObject(sql, new UserMapper(), id);
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateUser(User user) {
        try {
            String sql = String.format("UPDATE %s SET first_name = ?, last_name = ?, email = ?, age = ?, address = ?, joining_date = ? WHERE id = ?", USER_TABLE);
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAge(), user.getAddress(), user.getJoiningDate(), user.getId());
            return "User updated successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteUserById(Integer id) {
        try {
            String sql = String.format("DELETE FROM %s WHERE id = ?", USER_TABLE);
            jdbcTemplate.update(sql, id);
            String resultMessage = pollsSystemService.deleteAnswersByUserId(id);
            return "User deleted successfully " + resultMessage;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            String sql = String.format("SELECT * FROM %s", USER_TABLE);
            List<User> users = jdbcTemplate.query(sql, new UserMapper());
            return users;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
