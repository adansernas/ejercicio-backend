package com.asernas.backend.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Adan Sernas - adansernas@gmail.com
 */
@Data
public class ApiResponseBody {

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;

    public ApiResponseBody() {
        this.errors = new ArrayList<>();
    }

    public ApiResponseBody setMessage(String message) {
        this.message = message;

        return this;
    }

    public ApiResponseBody addError(String error) {
        this.errors.add(error);

        return this;
    }

    public ApiResponseBody addErrors(List<String> errors) {
        this.errors.addAll(errors);

        return this;
    }

    public ApiResponseBody nonErrors() {
        this.errors = null;

        return this;
    }

}
