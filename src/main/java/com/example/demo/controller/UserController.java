package com.example.demo.controller;

import com.example.demo.entity.RoleType;
import com.example.demo.entity.Session;
import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    Session session;

    public UserController(UserService userService, Session session){
        this.userService = userService;
        this.session = session;
    }

    @PostMapping
    public User authorizeUser(User user, Session session){
        return userService.authorizeUser(user, session);
    }

    @PostMapping
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    // Аннотация для частичного обновления сущности
    @PatchMapping("/updatePasswordById")
    public User updatePasswordHashById(int id, String newPassword){
        return userService.updatePasswordHashById(id, newPassword);
    }

    @PatchMapping("/updatePasswordByLogin")
    public User updatePasswordHashByLogin(String login, String newPassword){
        return userService.updatePasswordHashByLogin(login, newPassword);
    }

    @GetMapping(value = "/findById/{id}")
    public User findById(@PathVariable int id){
        return userService.findById(id);
    }

    @GetMapping(value = "/findByLogin/{login}")
    public User findById(@PathVariable String login){
        return userService.findByLogin(login);
    }

    @GetMapping("/info")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/roleTypes")
    public List<RoleType> getAllRoleTypes(){
        return userService.getAllRoleTypes();
    }

    @GetMapping("/currentProfileInfo")
    User getCurrentProfileInfo(Session session){
        return userService.getCurrentProfileInfo();
    }
}
