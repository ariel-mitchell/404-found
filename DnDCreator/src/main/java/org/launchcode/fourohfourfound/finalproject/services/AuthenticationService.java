package org.launchcode.fourohfourfound.finalproject.services;

import models.User;
import org.launchcode.fourohfourfound.finalproject.repositories.UserRepository;
import org.launchcode.fourohfourfound.finalproject.dtos.LoginFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public boolean authenticateUser(LoginFormDTO loginFormDTO) {
        User user = userRepository.findByUsername(loginFormDTO.getUsername());
        return user != null && user.isMatchingPassword(loginFormDTO.getPassword());
    }
}

