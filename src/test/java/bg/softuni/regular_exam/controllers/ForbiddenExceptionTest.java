package bg.softuni.regular_exam.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForbiddenExceptionTest {

    ForbiddenException exception;
    @BeforeEach
    void before(){
        exception = new ForbiddenException("test","id");
    }
    @Test
    void getId() {
        assertEquals(exception.getId(),"id");
    }
}