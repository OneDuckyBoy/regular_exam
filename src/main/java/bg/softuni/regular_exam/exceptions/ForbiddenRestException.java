package bg.softuni.regular_exam.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ForbiddenRestException extends RuntimeException{
    public ForbiddenRestException(String message) {
        super(message);
    }
}
