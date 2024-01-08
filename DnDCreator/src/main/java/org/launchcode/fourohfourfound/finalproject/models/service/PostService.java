package models.service;


import models.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import models.Data.PostRepository;
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
        //takes the post object as an argument, save data to repo
        return postRepository.save(post);
    }
    //Method to delete post (admin only)
}
