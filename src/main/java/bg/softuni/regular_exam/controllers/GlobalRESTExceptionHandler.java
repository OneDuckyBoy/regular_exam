package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.exceptions.ForbiddenRestException;
import jakarta.servlet.http.HttpServletRequest;
import org.antlr.v4.runtime.atn.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalRESTExceptionHandler {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({ForbiddenException.class,
            ForbiddenRestException.class})
    public  String handleRESTErrors(HttpServletRequest req
                                                    ) {
        return "/error";
    }


}
