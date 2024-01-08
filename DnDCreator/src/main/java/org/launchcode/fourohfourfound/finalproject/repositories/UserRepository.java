package org.launchcode.fourohfourfound.finalproject.repositories;

import org.launchcode.fourohfourfound.finalproject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    User findByEmail(String email);
}
