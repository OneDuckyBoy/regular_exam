package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

    private UserDetailsServiceImpl userDetailsService;
    private FilesStorageServiceImpl filesStorageService;
    private final Path root = Paths.get("src/main/resources/static/images/uploads/");
    @Mock
    private UserRepository mockUserRepository;
    private static UserEntity CreateTestUser(){
        return new UserEntity("test@example.com", "password");
    }

    @BeforeEach
    void Setup (){
        userDetailsService = new UserDetailsServiceImpl(mockUserRepository);
    }
    @Test
    void testInitializingUserDetailsServiceImpl(){
        new UserDetailsServiceImpl(mockUserRepository);
    }
    @Test
    void testLoadUserByUsername(){
        UserEntity user = new UserEntity();
        String email = "test@test.com";
        String password = "1234";

        user.setEmail(email);
        user.setPassword(password);

        Mockito.when(mockUserRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));


        UserDetails userDetails = userDetailsService.loadUserByUsername(email);


        Assertions.assertEquals("test@test.com",user.getEmail(),"Wrong email");
        Assertions.assertEquals("1234",user.getPassword(),"Wrong password");


    }



}