package models.Data;

import models.Alignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlignmentRepository extends CrudRepository<Alignment, Integer> {}