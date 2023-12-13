package controllers;

import models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PostService;
import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    // Endpoint to create a new post via HTTP POST request
    @PostMapping("/posts/create")
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        //create a post
        return ResponseEntity.ok("Post Created!");
    }
}