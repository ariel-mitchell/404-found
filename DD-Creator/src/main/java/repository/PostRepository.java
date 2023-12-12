package repository;


import models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// interface for handling Post entity in database
public interface PostRepository extends JpaRepository<Post, Long> {

}
