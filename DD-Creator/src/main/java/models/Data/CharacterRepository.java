package models.Data;

import jakarta.transaction.Transactional;
import models.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CharacterRepository extends CrudRepository<Character, Integer> {}