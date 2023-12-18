package bg.softuni.regular_exam.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class LoggedInInterceptor implements HandlerInterceptor {




    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println();
        if (!auth.getPrincipal().equals("anonymousUser")){
            response.sendRedirect("/error");

            return false;

        }
        return true;
    }

}

