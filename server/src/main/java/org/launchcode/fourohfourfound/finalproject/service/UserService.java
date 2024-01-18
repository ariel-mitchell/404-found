//package org.launchcode.fourohfourfound.finalproject.service;
//
//
//import org.launchcode.fourohfourfound.finalproject.dtos.LoginFormDTO;
//import org.launchcode.fourohfourfound.finalproject.models.User;
//import org.launchcode.fourohfourfound.finalproject.repositories.UserRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//
//    }
//
//    public User registerNewUserAccount(LoginFormDTO accountDto) {
//        User user = new User();
//        user.setUsername(accountDto.username());
//        user.setEmail(accountDto.email());
//        user.setPassword(passwordEncoder.encode(accountDto.password()));
//        try {
//            return userRepository.save(user);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error saving user", e);
//        }
//    }
//}
