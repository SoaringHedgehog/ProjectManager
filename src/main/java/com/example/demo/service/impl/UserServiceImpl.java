package com.example.demo.service.impl;

import com.example.demo.model.entity.RoleTypeEnum;
import com.example.demo.model.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.base.UserRepository;
import com.example.demo.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // TODO Без реализации
    @Override
    public UserEntity authorizeUser(UserEntity userEntity) {
        return userEntity;
    }

    @Override
    public UserEntity registerUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    @Transactional
    public UserEntity updatePasswordHashById(int id, String newPassword){
        return userRepository.updatePasswordHashById(id, newPassword);
    }

    @Override
    @Transactional
    public UserEntity updatePasswordHashByLogin(String login, String newPassword){
        return userRepository.updatePasswordHashByLogin(login, newPassword);
    }

    @Override
    public UserEntity findById(int userId){
        return userRepository.findById(userId);
    }

    @Override
    public UserEntity findByLogin(String login){
        return userRepository.findByLogin(login);
    }

    @Override
    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public List<RoleTypeEnum> getAllRoleTypes(){
        return List.of(RoleTypeEnum.values());
    }
}
