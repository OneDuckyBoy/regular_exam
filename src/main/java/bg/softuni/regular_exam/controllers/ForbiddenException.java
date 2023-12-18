package bg.softuni.regular_exam.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Product was not found.")
public class ForbiddenException extends RuntimeException {

    private final String id;


    public ForbiddenException(String message, String id) {
        super(message);
        this.id = id;
    }

    public String getId() {
        return id;
    }

}


