package models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
public class User extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String username;

    private String email;

    private String password;

    private BCryptPasswordEncoder passwordEncoder;

    public User() {
    }
    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = hashPassword(password);
    }

    public User(String username, String password) {
    }

    private String hashPassword(String password){
        return passwordEncoder.encode(password);
    }
    public boolean isMatchingPassword(String password){
        return passwordEncoder.matches(password, this.password);
    }

    //getters and setters for User field
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
