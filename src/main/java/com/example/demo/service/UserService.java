package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User registerUser(User user);
    User updatePasswordHashById(int id, String newPasswordHash);
    User updatePasswordHashByLogin(String login, String newPasswordHash);
    User findById(int userId);
    User findByLogin(String login);
}
