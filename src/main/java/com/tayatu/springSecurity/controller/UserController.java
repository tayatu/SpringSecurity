package com.tayatu.springSecurity.controller;

import com.tayatu.springSecurity.model.User;
import com.tayatu.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public User addUser(@RequestBody User user){
        userService.addUser(user);
        return  user;
    }
}
