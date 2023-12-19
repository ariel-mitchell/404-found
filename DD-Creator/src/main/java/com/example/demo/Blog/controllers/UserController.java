package com.example.demo.Blog.controllers;

import com.example.demo.Blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Blog.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //endpoint for creating new user
    @RequestMapping("/register")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    //other endpoints?
}