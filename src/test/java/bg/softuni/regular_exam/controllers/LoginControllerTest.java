package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.schedule.Theme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class LoginControllerTest {
    @InjectMocks
    private LoginController loginController;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Theme.darkTheme = true;  // Set Theme.darkTheme to true for the test
    }

    @Test
    void testLogin() {
        String viewName = loginController.login(model);

        assertEquals("login", viewName);

        // Verify the "darkTheme" attribute is added
        verify(model).addAttribute("darkTheme", Theme.darkTheme);
    }
}