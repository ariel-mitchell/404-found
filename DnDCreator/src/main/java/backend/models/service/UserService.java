package backend.models.service;

import backend.models.User;
import backend.models.dto.RegisterFormDTO;
import backend.models.*;

import java.util.List;

public interface UserService {
    void saveUser(RegisterFormDTO registerFormDTO);

    User findUserByUsername(String username);

    List<RegisterFormDTO> findAllUsers();
}