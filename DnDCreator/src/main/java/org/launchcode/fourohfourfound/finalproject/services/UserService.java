package models.dto;

import models.*;

import java.util.List;

public interface UserService {
    void saveUser(RegisterFormDTO registerFormDTO);

    User findUserByUsername(String username);

    List<RegisterFormDTO> findAllUsers();
}