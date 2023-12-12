package service;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

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
