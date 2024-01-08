package backend.config.service;

import java.util.List;
import backend.models.User;
import org.springframework.data.repository.query.Param;

public interface UserIService {

    List<User> findAll();
    User findByUsername(@Param("username") String username);
}
