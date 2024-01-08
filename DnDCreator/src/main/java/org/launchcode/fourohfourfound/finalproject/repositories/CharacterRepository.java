package org.launchcode.fourohfourfound.finalproject.repositories;

import jakarta.transaction.Transactional;
import org.launchcode.fourohfourfound.finalproject.models.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface CharacterRepository extends CrudRepository<Character, Integer> {
    Optional<Character> findById(int characterId);
}