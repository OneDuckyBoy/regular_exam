package bg.softuni.regular_exam.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
class GlobalExceptionHandlerTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void handleDatabaseErrors() {
        // @ExceptionHandler( ForbiddenException.class)
        //    public ModelAndView handleDatabaseErrors(ForbiddenException e) {
        //        ModelAndView modelAndView = new ModelAndView("error");
        //        modelAndView.addObject("message", e.getMessage());
        //
        //        return modelAndView;
        //    }}
        // Given
        ForbiddenException forbiddenException = new ForbiddenException("Access is forbidden","asd");

        // When
        ModelAndView modelAndView = GlobalExceptionHandler.handleDatabaseErrors(forbiddenException);

        // Then
        assertNotNull(modelAndView);
        assertEquals("error", modelAndView.getViewName());
        assertEquals("Access is forbidden", modelAndView.getModel().get("message"));
    }
}