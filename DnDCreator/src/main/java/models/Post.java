package models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;
    private String content;
    @Column(name = "authorId")
    private Long authorId;

    @Transient //This field is not persistent in DB
    private String author;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    private long views;
    private long likes;
    private long comments;

    //Constructor
    public Post() {
    }

    public Post(String title, String content, Long authorId, String author, Date dateCreated, Long views, Long likes, Long comments) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.author = author;
        this.dateCreated = dateCreated;
        this.views = views;
        this.likes = likes;
        this.comments = comments;
    }

    // Getters and Setters for all fields

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getComments(){
        return comments;
    }
    public void setComments(long comments) {
        this.comments = comments;
    }

    //toString method
    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authorId=" + authorId +
                ", authorName='" + author + '\'' +
                ", dateCreated='" + dateCreated +
                ", views=" + views +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }
}