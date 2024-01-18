package org.launchcode.fourohfourfound.finalproject.config;

import org.launchcode.fourohfourfound.finalproject.repository.UserRepository;
import org.launchcode.fourohfourfound.finalproject.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

}
