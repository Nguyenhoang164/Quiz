package com.example.quizwebsite.service;

import com.example.quizwebsite.model.Category;
import com.example.quizwebsite.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    User getUserById(int userId);

    List<User> getAllUsers() throws SQLException, ClassNotFoundException;

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId) throws SQLException, ClassNotFoundException;

    void addCategory(Category category);

}