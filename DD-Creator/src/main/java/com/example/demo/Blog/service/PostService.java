package com.example.demo.Blog.service;

import com.example.demo.Blog.models.Comment;
import com.example.demo.Blog.models.Post;
import com.example.demo.Blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Blog.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PostService(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    // Get all posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Get posts by keyword
    public List<Post> getPostsByKeyword(String keyword) {
        return postRepository.findByKeyword(keyword);
    }

    // Get post by ID
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    // Update Post
    public Post updatePost(Long id, Post updatedPost) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post not found with id: " + id));

        // Update fields
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setAuthor(updatedPost.getAuthor());

        // Save and return updated post
        return postRepository.save(existingPost);
    }

    // Create a new post
    public Post createPost(Post post) {
        // Save new post and return it
        return postRepository.save(post);
    }

    // Add Comment to Post
    public Comment addComment(Long postId, Comment comment) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post not found with id: " + postId));

        comment.setPost(post);
        commentRepository.save(comment);

        return comment;
    }

    // Get Comments for Post
    public List<Comment> getCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post not found with id: " + postId));

        return post.getComments();
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



