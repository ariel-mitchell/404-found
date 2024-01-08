package models.service;

import models.User;
import models.Data.UserRepository;
import models.dto.LoginFormDTO;
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

