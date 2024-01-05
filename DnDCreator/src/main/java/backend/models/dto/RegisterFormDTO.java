package backend.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterFormDTO extends LoginFormDTO {

    @NotBlank(message = "Passwords do not match.")
    @NotNull(message = "Passwords do not match.")
    @Size(min = 6, message = "Password must be at least 6 characters.")
    private String verifyPassword;

    public RegisterFormDTO() {}

    public RegisterFormDTO(String username, String password, String verifyPassword) {
        super(username, password);
        this.verifyPassword = verifyPassword;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }
    // Getters and setters.

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

}

