package com.example.demo.controller;

import com.example.demo.model.entity.RoleTypeEnum;
import com.example.demo.model.entity.UserEntity;
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
    public UserEntity authorizeUser(@RequestBody UserEntity userEntity){
        return userService.authorizeUser(userEntity);
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<?> registerUser(@RequestBody UserEntity userEntity){
        try{
            UserEntity userEntityForResponse = userService.registerUser(userEntity);
            return new ResponseEntity<>(userEntityForResponse, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        try{
            UserEntity userEntity = userService.findById(id);
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/findByLogin/{login}")
    public ResponseEntity<?> findByLogin(@PathVariable String login){
        try{
            UserEntity userEntity = userService.findByLogin(login);
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "/updatePasswordById/{id}")
    public ResponseEntity<?> updatePasswordHashById(@PathVariable int id, @RequestBody String newPassword){
        try{
            UserEntity userEntity = userService.updatePasswordHashById(id, newPassword);
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/updatePasswordByLogin/{login}")
    public ResponseEntity<?> updatePasswordHashByLogin(@PathVariable String login, @RequestBody String newPassword){
        try{
            UserEntity userEntity = userService.updatePasswordHashByLogin(login, newPassword);
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/info")
    public List<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/roleTypes")
    public List<RoleTypeEnum> getAllRoleTypes(){
        return userService.getAllRoleTypes();
    }
}
