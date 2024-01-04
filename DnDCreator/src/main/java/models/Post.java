package models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    //@JoinColumn(name = "category_id")
    private Category category;
    private String title;
    private String content;
    private String author;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    public Post(Category category) {
        this.category = category;
    }

    public Post(Category category, String title, String content, String author) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.author = author;
        this.dateCreated = new Date(); // Assuming current date/time on creation
    }

    // Getters and Setters for all fields
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