package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.dto.UserRegisterDTO;
import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.repositories.NewsRepository;
import bg.softuni.regular_exam.repositories.UserRepository;
import bg.softuni.regular_exam.services.RoleService;
import bg.softuni.regular_exam.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class UserServiceImplTest {


    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private  PasswordEncoder passwordEncoder;
    @Mock
    private  ModelMapper modelMapper;

    @Mock
    private  RoleService roleService;


    @BeforeEach
    void Setup(){


        userService = new UserServiceImpl(userRepository,passwordEncoder,modelMapper,roleService);
        modelMapper = new ModelMapper();
    }

    @Test
    void register() {

        UserEntity user = new UserEntity();
        user.setEmail("email@email.com");
        user.setPassword("pass");
        user.setUsername("steli");

        Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
        Mockito.when(passwordEncoder.encode("pass")).thenReturn("asd");

        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setAdmin(false);
        userRegisterDTO.setEmail("email@email.com");
        userRegisterDTO.setPassword(passwordEncoder.encode("pass"));
        userRegisterDTO.setUsername("steli");
        UserEntity register = userRepository.findByEmail(user.getEmail()).get();
        //UserEntity register = userService.register(userRegisterDTO);
        assertEquals("pass",register.getPassword());
        assertEquals("steli",register.getUsername());
        assertEquals("email@email.com",register.getEmail());

    }

    @Test
    void getUserByEmail() {
        UserEntity user = new UserEntity();
        UserEntity newUser = new UserEntity();

        Mockito.when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(newUser));
        user = userRepository.findByEmail(user.getEmail()).get();
        assertEquals(newUser,user);



    }

    @Test
    void getUserByEmailOptional() {
        //todo
    }

    @Test
    void saveItemToCart() {
        //todo

    }

    @Test
    void saveItemToLiked() {
        //todo

    }

    @Test
    void saveUser() {
        //todo

    }

    @Test
    void removeItemFromLiked() {
        //todo

    }

    @Test
    void removeItemFromCart() {
        //todo

    }

    @Test
    void getLikedItemsFromUser() {
        //todo

    }

    @Test
    void getCartItemsFromUser() {
        //todo

    }

    @Test
    void getLikedCartItemsFromUser() {
        //todo

    }

    @Test
    void setUserCartPrice() {
        //todo

    }
}