package org.launchcode.fourohfourfound.finalproject.repository;

import org.launchcode.fourohfourfound.finalproject.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {


}
