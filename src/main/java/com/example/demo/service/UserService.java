package com.example.demo.service;

import com.example.demo.model.entity.RoleTypeEnum;
import com.example.demo.model.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity authorizeUser(UserEntity userEntity);
    UserEntity registerUser(UserEntity userEntity);
    UserEntity findById(int userId);
    UserEntity findByLogin(String login);
    UserEntity updatePasswordHashById(int id, String newPasswordHash);
    UserEntity updatePasswordHashByLogin(String login, String newPasswordHash);
    List<UserEntity> getAllUsers();
    List<RoleTypeEnum> getAllRoleTypes();
    //UserEntity getCurrentProfileInfo();
}
