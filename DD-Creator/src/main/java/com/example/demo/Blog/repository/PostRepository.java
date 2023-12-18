package com.example.demo.Blog.repository;


import com.example.demo.Blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// interface for handling Post entity in database
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByKeyword(String lowercaseKeyword);

    Optional<Object> findAllById(Long id);
}
