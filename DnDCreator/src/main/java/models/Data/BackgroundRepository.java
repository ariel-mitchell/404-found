package models.Data;

import models.Background;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackgroundRepository extends CrudRepository<Background, Integer> {}