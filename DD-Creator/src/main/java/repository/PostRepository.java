package repository;


import models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// interface for handling Post entity in database
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}