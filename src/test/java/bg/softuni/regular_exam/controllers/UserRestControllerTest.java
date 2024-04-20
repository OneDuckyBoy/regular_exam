package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.repositories.UserRepository;
import bg.softuni.regular_exam.services.UserService;
import bg.softuni.regular_exam.services.impl.UserServiceImpl;
import com.azure.core.annotation.Put;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

//@WebMvcTest
@SpringBootTest
@AutoConfigureMockMvc
class UserRestControllerTest {
    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mvc;


//    public UserRestController userRestController;

//    @Autowired
//    @Mock
    @InjectMocks
    private UserServiceImpl userService;
//    private UserRepository userRepository;
    public String password="test";
    public String email="test@test.com";
    public String username = "test";
//    @Mock
//    public Model model;

//    @Mock
//    public CheckoutController checkoutController;
    @BeforeEach
    public void Setup(){

//        userService = new UserServiceImpl()
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();


        UserEntity user = new UserEntity();

        user.setPassword(password);
        user.setEmail(email);
        user.setUsername(username);
        Mockito.when(userService.GetUserByEmail()).thenReturn(user);
    }

    //@Test
    public void test_addToCart()  {
    //todo
        //
//        userRestController = new UserRestController(userService);
//       assertEquals(1, userRestController.addToCart(5,model ));
//        mvc.perform(get("/setCartPrice/5").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());



    }


}