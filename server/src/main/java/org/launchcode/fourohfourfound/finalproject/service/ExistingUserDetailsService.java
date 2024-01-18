package org.launchcode.fourohfourfound.finalproject.service;

import org.launchcode.fourohfourfound.finalproject.models.User;
import org.launchcode.fourohfourfound.finalproject.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ExistingUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public ExistingUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameIgnoreCase(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
               Collections.singleton(new SimpleGrantedAuthority("USER")));
    }
}
