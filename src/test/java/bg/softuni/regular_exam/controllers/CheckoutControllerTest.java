package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.dto.CheckoutDTO;
import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.schedule.Theme;
import bg.softuni.regular_exam.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CheckoutControllerTest {


    @Mock
    private UserService userService;

    @InjectMocks
    private CheckoutController checkoutController;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;
    @Mock
    private RedirectAttributes redirectAttributes;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCheckout() {
        // Given
        UserEntity user = new UserEntity();
        when(userService.GetUserByEmail()).thenReturn(user);



        // When
        ModelAndView modelAndView = checkoutController.checkout(model);

        // Then
        assertNotNull(modelAndView);
        assertEquals("/checkout", modelAndView.getViewName());

    }

    @Test
    void testCart() {
        // Given
        when(model.containsAttribute("price")).thenReturn(false);

        // When
        String viewName = checkoutController.cart(model);

        // Then
        assertNotNull(viewName);
        assertEquals("cart", viewName);



    }

    @Test
    void testCartPost() {
        // When
        String result = checkoutController.cartPost();

        // Then
        assertEquals("redirect:/checkout", result);
    }

    @Test
    void testCheckoutPost_WithErrors() {
        // Given
        CheckoutDTO checkoutDTO = new CheckoutDTO();
        when(bindingResult.hasErrors()).thenReturn(true);

        // When
        ModelAndView modelAndView = checkoutController.checkoutPost(checkoutDTO, bindingResult, redirectAttributes);

        // Then
        assertEquals("/checkout", modelAndView.getViewName());
        verify(redirectAttributes).addFlashAttribute("checkoutDTO", checkoutDTO);
        verify(redirectAttributes).addFlashAttribute(
                eq("org.springframework.validation.BindingResult.SomeModel"), eq(bindingResult));
    }

    @Test
    void testCheckoutPost_NoErrors() {
        // Given
        CheckoutDTO checkoutDTO = new CheckoutDTO();
        when(bindingResult.hasErrors()).thenReturn(false);

        // When
        ModelAndView modelAndView = checkoutController.checkoutPost(checkoutDTO, bindingResult, redirectAttributes);

        // Then
        assertTrue(modelAndView.getViewName().startsWith("redirect:/thanks_for_purchase/"));
        verify(userService).removeItemsFromCart();
        verify(userService).setUserCartPrice(0);
    }
}