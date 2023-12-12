package service;

import models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PostRepository;

import java.util.List;

//Service for managing operations related to Post entity
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    //Method to retrieve all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    //Method to create a new post
    public Post createPost(Post post) {
        //takes the post object as an argument, indicating that the intention is to save the data represented by the post object using the repository.
        return postRepository.save(post);
    }
}
