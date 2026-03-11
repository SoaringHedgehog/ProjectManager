package com.example.demo.controller;

import com.example.demo.entity.RoleType;
import com.example.demo.entity.Session;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    // Аннотация для частичного обновления сущности
    @PatchMapping("/{id}/password")
    public User updatePasswordHashById(int id, String newPassword){
        return userService.updatePasswordHashById(id, newPassword);
    }

    @PatchMapping("/by-login/password")
    public User updatePasswordHashByLogin(String login, String newPassword){
        return userService.updatePasswordHashByLogin(login, newPassword);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int userId){
        return userService.findById(userId);
    }

    void printCurrentProfileInfo(Session session){}
    void printRoleTypes(){}
    RoleType chooseRoleType(int roleType){return RoleType.USER;}
}
