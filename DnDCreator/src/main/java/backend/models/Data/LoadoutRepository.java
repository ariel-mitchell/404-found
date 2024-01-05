package backend.models.Data;

import backend.models.Loadout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadoutRepository extends CrudRepository<Loadout, Integer> {}