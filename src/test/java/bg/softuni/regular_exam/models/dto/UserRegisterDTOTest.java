package bg.softuni.regular_exam.models.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegisterDTOTest {

    private UserRegisterDTO userRegisterDTO;
    private final String email="test_email@asd.com";
    private final String password ="pass";
    private final String confirmPassword = "pass";
    private final String username = "dummy username";
    private final boolean admin=false;

    @BeforeEach
    void setUp() {
        userRegisterDTO = new UserRegisterDTO();


    }
    @Test
    void getEmail() {


    }

    @Test
    void setEmail() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void setPassword() {
    }

    @Test
    void getConfirmPassword() {
    }

    @Test
    void setConfirmPassword() {
    }

    @Test
    void isAdmin() {
        userRegisterDTO.setAdmin(admin);
        assertEquals(admin,userRegisterDTO.isAdmin());
    }

    @Test
    void setAdmin() {
        userRegisterDTO.setAdmin(admin);
        assertEquals(admin,userRegisterDTO.isAdmin());
    }

    @Test
    void getUsername() {
        userRegisterDTO.setUsername(username);
        assertEquals(username,userRegisterDTO.getUsername());
    }

    @Test
    void setUsername() {
        userRegisterDTO.setUsername(username);
        assertEquals(username,userRegisterDTO.getUsername());
    }


}