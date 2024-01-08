package backend.config.service;


import backend.models.*;
import backend.models.Data.UserRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableJpaRepositories(basePackages = {"backend.models.data"})
public class UserService implements UserIService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }


   @Override
    public User findByUsername(@Param("username") String username) {
        return userRepository.findByUsername();
    }
}