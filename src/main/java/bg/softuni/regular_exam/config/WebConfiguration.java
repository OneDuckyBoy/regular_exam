package bg.softuni.regular_exam.config;

import bg.softuni.regular_exam.interceptors.LoggedInInterceptor;
//import bg.softuni.regular_exam.interceptors.LoggedOutInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer  {
    private final LoggedInInterceptor loggedInInterceptor;
//    private final LoggedOutInterceptor loggedOutInterceptor;
    public WebConfiguration(LoggedInInterceptor myInterceptor
//            , LoggedOutInterceptor
                            ) {
        this.loggedInInterceptor = myInterceptor;
//        this.loggedOutInterceptor = loggedOutInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggedInInterceptor).addPathPatterns("/login", "/register", "/login-error");
//        registry.addInterceptor(loggedOutInterceptor).addPathPatterns( "/login", "/register", "/login-error");
//        registry.addInterceptor(new ThemeChangeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
    }
}
