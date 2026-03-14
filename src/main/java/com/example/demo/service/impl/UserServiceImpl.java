package com.example.demo.service.impl;

import com.example.demo.entity.RoleType;
import com.example.demo.entity.Session;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    private final Session session;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Session session){
        this.userRepository = userRepository;
        this.session = session;
    }

    public User authorizeUser(User user, Session session) {
        if(session.isAuthenticated()){
            throw new RuntimeException("Вход уже выполнен");
        }

        User userByLogin = userRepository.findByLogin(user.getLogin());
        if(userByLogin != null && userByLogin.getPasswordHash().equals(user.getPasswordHash())){
            System.out.println("Вход выполнен успешно");
            session.setCurrentUser(user);
        }
        else
        {
            System.out.println("Неправильный логин или пароль");
        }
        return user;
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

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<RoleType> getAllRoleTypes(){
        return List.of(RoleType.values());
    }

    public User getCurrentProfileInfo(){
        return session.getCurrentUser();
    }
}
