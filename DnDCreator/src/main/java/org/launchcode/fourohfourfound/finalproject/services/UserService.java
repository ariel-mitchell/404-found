package org.launchcode.fourohfourfound.finalproject.services;

import org.launchcode.fourohfourfound.finalproject.dtos.RegisterFormDTO;
import org.launchcode.fourohfourfound.finalproject.models.*;

import java.util.List;

public interface UserService {
    void saveUser(RegisterFormDTO registerFormDTO);

    User findUserByUsername(String username);

    List<RegisterFormDTO> findAllUsers();
}