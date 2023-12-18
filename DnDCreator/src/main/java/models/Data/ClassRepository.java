package models.Data;

import models.ClassInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends CrudRepository<ClassInfo, Integer> {}