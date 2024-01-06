package backend.models.Data;

import backend.models.Comment;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository<C, L extends Number> extends CrudRepository<Comment, Long> {

}