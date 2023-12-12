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
}
