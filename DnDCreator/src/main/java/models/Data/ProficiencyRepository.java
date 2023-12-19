package models.Data;

import models.Proficiencies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProficiencyRepository extends CrudRepository<Proficiencies, Integer> {}