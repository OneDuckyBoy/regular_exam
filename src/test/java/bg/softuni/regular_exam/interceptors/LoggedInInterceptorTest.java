package bg.softuni.regular_exam.interceptors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.method.HandlerMethod;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoggedInInterceptorTest {
    @Mock
    private SecurityContext securityContext;

    @InjectMocks
    private LoggedInInterceptor interceptor;

    @Test
    void preHandle1() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        Authentication auth = new UsernamePasswordAuthenticationToken("user", "password");
        SecurityContextHolder.setContext(securityContext);
        when(securityContext.getAuthentication()).thenReturn(auth);

        // When
        boolean result = interceptor.preHandle(request, response, null);

        // Then
        assertFalse(result);
        assertEquals("/error", response.getRedirectedUrl());
    }
    @Test
    void preHandle2() throws Exception {
        // Given
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        SecurityContextHolder.setContext(securityContext);
        //when(securityContext.getAuthentication()).thenReturn(null); // Simulating anonymous user
        when(securityContext.getAuthentication()).thenReturn(new UsernamePasswordAuthenticationToken("anonymousUser", null)); // Simulating anonymous user

        // When
        boolean result = interceptor.preHandle(request, response, null);

        // Then
        assertTrue(result);
        assertNull(response.getRedirectedUrl());
    }
}