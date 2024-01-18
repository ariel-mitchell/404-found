package org.launchcode.fourohfourfound.finalproject.repositories;


import org.launchcode.fourohfourfound.finalproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameIgnoreCase(String username);
    User findByEmail(String email);

    boolean existsByUsername(String username);
}
