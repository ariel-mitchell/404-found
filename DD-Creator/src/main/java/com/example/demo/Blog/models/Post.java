package com.example.demo.Blog.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Explicitly specify the ID generation strategy
    private Long id;

    private String title;
    private String content;
    private String author;

    @Temporal(TemporalType.TIMESTAMP) // Specify the temporal type for dateCreated
    private Date dateCreated;

    private String keyword;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL) // mappedBy refers to the field in Comment class
    private List<Comment> comments = new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
