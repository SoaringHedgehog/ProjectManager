package com.example.demo.service;

import com.example.demo.entity.RoleType;
import com.example.demo.entity.Session;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    User authorizeUser(User user, Session session);
    User registerUser(User user);
    User updatePasswordHashById(int id, String newPasswordHash);
    User updatePasswordHashByLogin(String login, String newPasswordHash);
    User findById(int userId);
    User findByLogin(String login);
    List<User> getAllUsers();
    List<RoleType> getAllRoleTypes();
    User getCurrentProfileInfo();
}
