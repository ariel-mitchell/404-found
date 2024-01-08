package backend.config.dto;

import static org.springframework.util.Assert.notNull;
import static org.thymeleaf.util.Validate.notEmpty;

final class FieldErrorDTO {

    private final String field;

    private final String message;

    FieldErrorDTO(String field, String message) {
        notNull(field, "Field cannot be null.");
        notEmpty(field, "Field cannot be empty");

        notNull(message, "Message cannot be null.");
        notEmpty(message, "Message cannot be empty.");

        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}