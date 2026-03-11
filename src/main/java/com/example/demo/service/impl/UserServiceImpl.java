package com.example.demo.service.impl;

import com.example.demo.entity.RoleType;
import com.example.demo.entity.Session;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User updatePasswordHashById(int id, String newPassword){
        return userRepository.updatePasswordHashById(id, newPassword);
    }

    public User updatePasswordHashByLogin(String login, String newPassword){
        return userRepository.updatePasswordHashByLogin(login, newPassword);
    }

    public User findById(int userId){
        return userRepository.findById(userId);
    }

    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }

    public void printRoleTypes(){
        RoleType[] roleTypes = RoleType.values();
        for (int i = 0; i < roleTypes.length; i++) {
            System.out.println(i + " " + roleTypes[i]);
        }
    }

    public RoleType chooseRoleType(int roleType){
        RoleType[] roleTypes = RoleType.values();
        if(roleType < 0 || roleType > roleTypes.length - 1){
            throw new RuntimeException("Такой роли не существует");
        }
        return roleTypes[roleType];
    }
}
