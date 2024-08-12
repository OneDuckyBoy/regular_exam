package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.exceptions.ForbiddenRestException;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class GlobalRESTExceptionHandlerTest {
    private GlobalRESTExceptionHandler globalRESTExceptionHandler;

    @BeforeEach
    void setUp() {
        globalRESTExceptionHandler = new GlobalRESTExceptionHandler();
    }

    @Test
    void testHandleRESTErrors_ForbiddenException() {
        // Given
        HttpServletRequest request = mock(HttpServletRequest.class);

        // When
        String viewName = globalRESTExceptionHandler.handleRESTErrors(request);

        // Then
        assertEquals("/error", viewName);
    }


}