package com.example.demo.service;

import com.example.demo.model.entity.RoleTypeEnum;
import com.example.demo.model.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // TODO Без реализации
    public UserEntity authorizeUser(UserEntity userEntity) {
        return userEntity;
    }

    public UserEntity registerUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Transactional
    public int updatePasswordHashById(UUID id, String newPassword){
        return userRepository.updatePasswordHashById(id, newPassword);
    }

    @Transactional
    public int updatePasswordHashByLogin(String login, String newPassword){
        return userRepository.updatePasswordHashByLogin(login, newPassword);
    }

    public UserEntity findById(UUID userId){
        return userRepository.findById(userId).orElse(null);
    }

    public UserEntity findByLogin(String login){
        return userRepository.findByLogin(login);
    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public List<RoleTypeEnum> getAllRoleTypes(){
        return List.of(RoleTypeEnum.values());
    }
}
