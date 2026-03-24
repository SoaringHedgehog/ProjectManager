package com.example.demo.controller;

import com.example.demo.model.entity.RoleType;
import com.example.demo.model.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> registerUser(@RequestBody User user){
        try{
            User userForResponse = userService.registerUser(user);
            return new ResponseEntity<>(userForResponse, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        try{
            User user = userService.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findByLogin/{login}")
    public ResponseEntity<?> findByLogin(@PathVariable String login){
        try{
            User user = userService.findByLogin(login);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "/updatePasswordById/{id}")
    public ResponseEntity<?> updatePasswordHashById(@PathVariable int id, @RequestBody String newPassword){
        try{
            User user = userService.updatePasswordHashById(id, newPassword);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/updatePasswordByLogin/{login}")
    public ResponseEntity<?> updatePasswordHashByLogin(@PathVariable String login, @RequestBody String newPassword){
        try{
            User user = userService.updatePasswordHashByLogin(login, newPassword);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
