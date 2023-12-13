package service;

import models.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
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


    // Endpoint to create a new post via HTTP POST request
    @PostMapping("/create")
    public Post createPost(Post post) {
        //takes the post object as an argument, save data to repo
        return postRepository.save(post);
    }
    //Method to delete post (admin only)
}
