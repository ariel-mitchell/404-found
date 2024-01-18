package org.launchcode.fourohfourfound.finalproject.service;

import org.launchcode.fourohfourfound.finalproject.dto.UserDTO;
import org.launchcode.fourohfourfound.finalproject.model.User;
import org.launchcode.fourohfourfound.finalproject.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User registerNewUserAccount(UserDTO accountDto) {
        User user = new User();
        user.setUserName(accountDto.userName());
        user.setFirstName(accountDto.firstName());
        user.setLastName(accountDto.lastName());
        user.setEmail(accountDto.email());
        user.setPassword(passwordEncoder.encode(accountDto.password()));
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error saving user", e);
        }
    }
}
