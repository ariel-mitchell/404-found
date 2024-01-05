package backend.models.Data;

import backend.models.Comment;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository<C, L extends Number> extends CrudRepository<Comment, Long> {

}