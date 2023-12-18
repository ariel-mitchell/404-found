package com.example.demo.Blog.service;

import com.example.demo.Blog.models.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;
import com.example.demo.Blog.repository.PostRepository;
import java.util.List;

//Service for managing operations related to Post entity
@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // Get all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Get by keyword
    public List<Post> getPostsByKeyword() {
        // TODO: Implement logic to search for posts by keyword
        return null;
    }

    // Get post by ID
    public Post getPostById() {
        // TODO: Implement logic to get post by ID
        return null;
    }

    // Create a new post
    public Post createPost(Post post) {
        // Save new post and return it
        return postRepository.save(post);
    }

    // Delete post by ID
    public void deletePost(Long id) {
        // TODO: Implement logic to delete post by ID
        if (postRepository.existsById(AbstractPersistable_.id)) {
            postRepository.deleteById(AbstractPersistable_.id);
    }
}

