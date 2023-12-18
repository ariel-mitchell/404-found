package com.example.demo.Blog.service;

import com.example.demo.Blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Blog.repository.UserRepository;

//UserService interacts with UserRepo for user related functions
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser (User user) {
        return userRepository.save(user);
    }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    //Other methods for user related functions?
}
