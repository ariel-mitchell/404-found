package org.launchcode.fourohfourfound.finalproject.repositories;

import org.launchcode.fourohfourfound.finalproject.models.Loadout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoadoutRepository extends CrudRepository<Loadout, Integer> {}