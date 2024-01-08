package backend.config.dto;

import static org.springframework.util.Assert.notNull;
import static org.thymeleaf.util.Validate.notEmpty;

final class ErrorDTO {

    private final String code;
    private final String message;

    ErrorDTO(String code, String message) {
        notNull(code, "Code cannot be null.");
        notEmpty(code, "Code cannot be empty.");

        notNull(message, "Message cannot be null.");
        notEmpty(message, "Message cannot be empty");

        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}