package bg.softuni.regular_exam.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForbiddenRestExceptionTest {
    @Test
    void  init(){
        ForbiddenRestException ex = new ForbiddenRestException("test");
    }

}