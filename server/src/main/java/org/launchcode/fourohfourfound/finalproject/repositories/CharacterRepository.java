package org.launchcode.fourohfourfound.finalproject.repositories;

import org.launchcode.fourohfourfound.finalproject.models.Character;
import org.launchcode.fourohfourfound.finalproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    List<Character> findByOwner(User owner);

}
