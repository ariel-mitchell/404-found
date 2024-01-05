package models.Data;


import models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// interface for handling Post entity in database
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByKeyword(String keyword);
}
