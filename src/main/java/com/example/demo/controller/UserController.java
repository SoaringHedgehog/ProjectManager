package com.example.demo.controller;

import com.example.demo.model.entity.RoleType;
import com.example.demo.model.entity.User;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/authorization")
    public User authorizeUser(@RequestBody User user){
        return userService.authorizeUser(user);
    }

    @PostMapping(value = "/registration")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping(value = "/findById/{id}")
    public User findById(@PathVariable int id){
        return userService.findById(id);
    }

    @GetMapping(value = "/findByLogin/{login}")
    public User findByLogin(@PathVariable String login){
        return userService.findByLogin(login);
    }

    // Аннотация для частичного обновления сущности
    @PatchMapping(value = "/updatePasswordById/{id}")
    public int updatePasswordHashById(@PathVariable int id, @RequestBody String newPassword){
        return userService.updatePasswordHashById(id, newPassword);
    }

    @PatchMapping("/updatePasswordByLogin/{login}")
    public int updatePasswordHashByLogin(@PathVariable String login, @RequestBody String newPassword){
        return userService.updatePasswordHashByLogin(login, newPassword);
    }

    @GetMapping("/info")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/roleTypes")
    public List<RoleType> getAllRoleTypes(){
        return userService.getAllRoleTypes();
    }
}
