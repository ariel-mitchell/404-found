package controllers;

import models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PostService;
import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    //Get All Post
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }
    //Get Post by {id}
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }


    // Endpoint to create a new post via HTTP POST request
    @PostMapping("/posts/create")
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        //create a post
        return ResponseEntity.ok("Post Created!");
    }
}