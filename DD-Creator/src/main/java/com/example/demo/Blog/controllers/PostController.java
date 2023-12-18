package com.example.demo.Blog.controllers;

import com.example.demo.Blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Blog.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Returns list of posts
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    // Get posts by keyword
    /* param keyword - keyword to search for in post content.
    returns List of posts matching the keyword.
    */
    @GetMapping("/search")
    public ResponseEntity<List<Post>> getPostsByKeyword(@RequestParam String keyword) {
        // convert the keyword to lowercase
        String lowercaseKeyword = keyword.toLowerCase();
        List<Post> posts = postService.getPostsByKeyword(lowercaseKeyword);
        return ResponseEntity.ok(posts);
    }

    // Get post by ID
    /* param id - ID of the post
    returns post with specified ID
    */
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    // Create new Post
    /* param post - post to be created
    returns created post
    */
    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    // Update a post
    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        Post updated = postService.updatePost(id, updatedPost);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build(); // Handle appropriately if the post with the given ID doesn't exist
        }
    }

    // Delete Post
    /* param id - ID of the post to be deleted
    returns no content
    */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
