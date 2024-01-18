package org.launchcode.fourohfourfound.finalproject.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class RegisterFormDTO extends LoginFormDTO {



    @Email(message = "Invalid email. Try again.")
    @NotBlank(message = "Email is required.")
    private String email;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;



    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
