package com.example.demo.Blog.service;

import com.example.demo.Blog.models.Post;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Post> getPostsByKeyword(String keyword) {
        return postRepository.findByKeyword(keyword);
    }

    // Get post by ID
    public Post getPostById(Long id) {
        return (Post) postRepository.findAllById(id).orElse(null);
    }


    // Create a new post
    public Post createPost(Post post) {
        // Save new post and return it
        return postRepository.save(post);
    }

    // Delete post by ID
    public void deletePost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
        } else {
            throw new PostNotFoundException("Post not found with id: " + id);
        }
    }
}


