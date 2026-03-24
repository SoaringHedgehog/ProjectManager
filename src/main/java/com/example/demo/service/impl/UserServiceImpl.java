package com.example.demo.service.impl;

import com.example.demo.model.entity.RoleType;
import com.example.demo.model.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;
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
    public User authorizeUser(User user) {
        return user;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updatePasswordHashById(int id, String newPassword){
        return userRepository.updatePasswordHashById(id, newPassword);
    }

    @Override
    @Transactional
    public User updatePasswordHashByLogin(String login, String newPassword){
        return userRepository.updatePasswordHashByLogin(login, newPassword);
    }

    @Override
    public User findById(int userId){
        return userRepository.findById(userId);
    }

    @Override
    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public List<RoleType> getAllRoleTypes(){
        return List.of(RoleType.values());
    }
}
