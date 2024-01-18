package org.launchcode.fourohfourfound.finalproject.models;

import jakarta.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name = "users")
public class User extends AbstractIdentifiableModel{

    @Column
    private String username;
    @Column
    private String email;

    @Column
    private String password;

    public User() {}



    public User(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        setPassword(password);

    }

    public String getUserName() {
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

    public void setPassword(String password) {
         this.password = password;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public static BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    public boolean isPasswordEmpty() {
        return password == null || password.isEmpty();
    }

    public boolean isMatchingPassword(String password) {
        return getEncoder().matches(password, this.password);
    }
}