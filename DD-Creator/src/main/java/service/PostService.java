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
    private final PostRepository postRepository;

    @Autowired
    private PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //Retrieve all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    //Retrieve a post by ID
    public Post getPostById(Long id) {
        //Post doesn't exist
        return postRepository.findById(id).orElse(null);
    }

    @PostMapping("/create")
    public Post createPost(Post post) {
        //takes the post object as an argument, save data to repo
        return postRepository.save(post);
    }
    //Method to delete post (admin only)
}
