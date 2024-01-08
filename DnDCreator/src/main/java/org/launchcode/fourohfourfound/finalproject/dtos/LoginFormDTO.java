package org.launchcode.fourohfourfound.finalproject.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class LoginFormDTO {
    @NotNull(message = "Username is required.")
    @NotBlank(message = "Username is required.")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
    private String username;
    @NotNull(message = "Password is required.")
    @NotBlank(message = "Password is required.")
    @Size(min = 6, message = "Password must be at least 6 characters.")
    private String password;

    public LoginFormDTO() {}

    public LoginFormDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters.

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


}
