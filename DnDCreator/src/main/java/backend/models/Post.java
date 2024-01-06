package backend.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;
    private String content;
    private Integer userId;

    @Transient //This field is not persistent in DB
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    private int views;
    private int likes;
    private int comments;

    //Constructor
    public Post() {
    }

    public Post(String title, String content, int userId, User user, Date dateCreated, int views, int likes, int comments) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.user = user;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void setViews(int views) {
        this.views = views;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public long getComments(){
        return comments;
    }
    public void setComments(int comments) {
        this.comments = comments;
    }

    //toString method
    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", user='" + user + '\'' +
                ", dateCreated='" + dateCreated +
                ", views=" + views +
                ", likes=" + likes +
                ", comments=" + comments +
                '}';
    }
}