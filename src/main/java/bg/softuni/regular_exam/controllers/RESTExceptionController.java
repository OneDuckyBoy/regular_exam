package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.exceptions.ForbiddenRestException;
import org.antlr.v4.runtime.atn.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RESTExceptionController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ForbiddenException.class)
    public ModelAndView handleNotFound(ForbiddenRestException exception){
        return new ModelAndView("error");
    }

}
