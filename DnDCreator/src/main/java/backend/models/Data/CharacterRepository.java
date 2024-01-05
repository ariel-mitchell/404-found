package backend.models.Data;

import backend.models.Character;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CharacterRepository extends CrudRepository<Character, Integer> {}