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
    void TestConstructorWithParameters(){
        UserRegisterDTO userRegisterDTO1 = new UserRegisterDTO("test1","test2","test2");
        assertEquals(userRegisterDTO1.getConfirmPassword(),"test2");
    }
    @Test
    void getEmail() {
        userRegisterDTO.setEmail("testEmail");
    assertEquals(userRegisterDTO.getEmail(),"testEmail");

    }

    @Test
    void setEmail() {
        userRegisterDTO.setEmail("testEmail");
        assertEquals(userRegisterDTO.getEmail(),"testEmail");
    }

    @Test
    void getPassword() {
        userRegisterDTO.setPassword("testPass");
        assertEquals(userRegisterDTO.getPassword(),"testPass");
    }

    @Test
    void setPassword() {
        userRegisterDTO.setPassword("testPass");
        assertEquals(userRegisterDTO.getPassword(),"testPass");
    }

    @Test
    void getConfirmPassword() {
        userRegisterDTO.setConfirmPassword("testPass");
        assertEquals(userRegisterDTO.getConfirmPassword(),"testPass");
    }

    @Test
    void setConfirmPassword() {
        userRegisterDTO.setConfirmPassword("testPass");
        assertEquals(userRegisterDTO.getConfirmPassword(),"testPass");
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