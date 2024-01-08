package backend.config.dto;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

final class ValidationErrorDTO {

    private final String code = HttpStatus.BAD_REQUEST.name();

    private final List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    ValidationErrorDTO() {
    }

    void addFieldError(String field, String message) {
        FieldErrorDTO error = new FieldErrorDTO(field, message);
        fieldErrors.add(error);
    }

    public String getCode() {
        return code;
    }

    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }
}