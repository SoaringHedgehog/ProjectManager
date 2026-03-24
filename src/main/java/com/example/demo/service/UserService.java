package com.example.demo.service;

import com.example.demo.model.entity.RoleType;
import com.example.demo.model.entity.User;

import java.util.List;

public interface UserService {
    User authorizeUser(User user);
    User registerUser(User user);
    User findById(int userId);
    User findByLogin(String login);
    int updatePasswordHashById(int id, String newPasswordHash);
    int updatePasswordHashByLogin(String login, String newPasswordHash);
    List<User> getAllUsers();
    List<RoleType> getAllRoleTypes();
    //User getCurrentProfileInfo();
}
