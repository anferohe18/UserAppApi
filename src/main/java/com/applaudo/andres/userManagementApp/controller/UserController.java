package com.applaudo.andres.userManagementApp.controller;

import com.applaudo.andres.userManagementApp.entity.UserEntity;
import com.applaudo.andres.userManagementApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@Valid @RequestBody UserEntity userEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }else{
            userService.createUser(userEntity);
            return "UserEntity created";
        }
    }

    @PostMapping("/addUsers")
    public List<UserEntity> addUsers(@RequestBody List<UserEntity> userEntities) {
        return userService.createUsers(userEntities);
    }

    @GetMapping("/user/{email}")
    public UserEntity getUserByEmail(@PathVariable(value = "email") String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userService.getUsers();
    }

    @PutMapping("/updateUser")
    public String updateUser(@Valid @RequestBody UserEntity userEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }else{
            userService.updateUser(userEntity);
            return "userEntity updated";
        }
    }

    @DeleteMapping("/deleteUser/{email}")
    public String deleteUser(@PathVariable String email) {
        return userService.deleteUserByEmail(email);
    }
}
