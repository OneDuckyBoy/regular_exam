package bg.softuni.regular_exam.config;

//import bg.softuni.regular_exam.model.enums.UserRoleEnum;
//import bg.softuni.regular_exam.repository.UserRepository;
//import bg.softuni.regular_exam.service.impl.MobileleUserDetailsService;
import bg.softuni.regular_exam.repositories.UserRepository;
import bg.softuni.regular_exam.services.ArduinoUserDetailsService;
import bg.softuni.regular_exam.services.impl.ArduinoUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

  private final String rememberMeKey;

  public SecurityConfiguration(@Value("${exam.remember.me.key}")
    String rememberMeKey) {
    this.rememberMeKey = rememberMeKey;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity.authorizeHttpRequests(
        // Define which urls are visible by which users
        authorizeRequests -> authorizeRequests
            // All static resources which are situated in js, images, css are available for anyone
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            // Allow anyone to see the home page, the registration page and the login form
            .requestMatchers("/","/index.html", "/login", "/register", "/login-error","/logout"
            ).permitAll()
//            .requestMatchers("/offers/all").permitAll()
//            .requestMatchers("/brands").hasRole(UserRoleEnum.ADMIN.name())
            // all other requests are authenticated.
            .anyRequest()
                .permitAll()
//                .authenticated()
    )
            .formLogin(
        formLogin -> {
          formLogin
              // redirect here when we access something which is not allowed.
              // also this is the page where we perform login.
              .loginPage("/login")
              // The names of the input fields (in our case in auth-login.html)
              .usernameParameter("email")
              .passwordParameter("password")
              .defaultSuccessUrl("/")
              .failureForwardUrl("/login-error");
          //todo roles
        }
    )

            .logout(
        logout -> {
          logout
              // the URL where we should POST something in order to perform the logout
              .logoutUrl("/logout")
              // where to go when logged out?
              .logoutSuccessUrl("/")
              // invalidate the HTTP session
              .invalidateHttpSession(true);
        }
    ).rememberMe(
        rememberMe -> {
          rememberMe
              .key(rememberMeKey)
              .rememberMeParameter("remember_me")
              .rememberMeCookieName("remember_me");
        }
    )
//            .exceptionHandling().accessDeniedPage("/accessDenied.jsp").and()
            .build();
  }

  @Bean
  public UserDetailsService userDetailsService(UserRepository userRepository) {
    return new ArduinoUserDetailsServiceImpl(userRepository);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
  }

}
