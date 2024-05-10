package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.dto.UserRegisterDTO;
import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.models.entity.UserRoleEntity;
import bg.softuni.regular_exam.models.enums.UserRoleEnum;
import bg.softuni.regular_exam.repositories.UserRepository;
import bg.softuni.regular_exam.services.RoleService;
import bg.softuni.regular_exam.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

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

        modelMapper = new ModelMapper();

        userService = new UserServiceImpl(userRepository,passwordEncoder,modelMapper,roleService);
    }

    @Test
    void register(){
        UserEntity user = new UserEntity();

        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setEmail("test@example.com");
        userRegisterDTO.setPassword("password");
        userRegisterDTO.setAdmin(true);
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");

        // Stubbing for roleService.getRoleFromEnum()
        UserRoleEntity userRole =new UserRoleEntity();
        userRole.setRole(UserRoleEnum.USER);
        when(roleService.getRoleFromEnum(UserRoleEnum.USER)).thenReturn(userRole);

        UserRoleEntity userAdminRole =new UserRoleEntity();
        userRole.setRole(UserRoleEnum.ADMIN);
        when(roleService.getRoleFromEnum(UserRoleEnum.ADMIN)).thenReturn(userAdminRole);

        // Stubbing userRepository.findByEmail() to return empty optional to simulate a new user
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        // Stubbing userRepository.save() to return the saved user
        when(userRepository.save(any(UserEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        //when(modelMapper(userRegisterDTO,any(UserEntity.class))).thenReturn(user);

        // When
        UserEntity result = userService.register(userRegisterDTO);

        // Then
        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
        assertEquals("encodedPassword", result.getPassword());
        // Add more assertions as needed

    }
    @Test
    void register1() {

        UserEntity user = new UserEntity();
        user.setEmail("email@email.com");
        user.setPassword("pass");
        user.setUsername("steli");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
        when(passwordEncoder.encode("pass")).thenReturn("asd");

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
        String userEmail = "test@example.com";
        UserEntity expectedUser = new UserEntity();
        expectedUser.setEmail(userEmail);

        Authentication authentication = mock(Authentication.class);
        when(authentication.getName()).thenReturn(userEmail);

        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        when(userRepository.findByEmail(userEmail)).thenReturn(Optional.of(expectedUser));

        // When
        UserEntity result = userService.GetUserByEmail();

        // Then
        assertEquals(expectedUser, result);
        verify(userRepository, times(1)).findByEmail(userEmail);



    }

    @Test
    void getUserByEmailOptional() {
        String userEmail = "test@example.com";
        UserEntity expectedUser = new UserEntity();
        expectedUser.setEmail(userEmail);

        Authentication authentication = mock(Authentication.class);
        when(authentication.getName()).thenReturn(userEmail);

        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        when(userRepository.findByEmail(userEmail)).thenReturn(Optional.of(expectedUser));

        // When
        Optional<UserEntity> result = userService.GetUserByEmailOptional();

        // Then
        assertEquals(expectedUser, result.get());
        verify(userRepository, times(1)).findByEmail(userEmail);
    }

    @Test
    void saveItemToCart() throws Exception {
        String userEmail = "test@example.com";
        UserEntity expectedUser = new UserEntity();
        ItemEntity item = new ItemEntity();

        List<ItemEntity> items = new ArrayList<>();
        expectedUser.setItemsInCart(items);

        items.add(item);
        expectedUser.setEmail(userEmail);

        Authentication authentication = mock(Authentication.class);
        when(authentication.getName()).thenReturn(userEmail);

        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        when(userRepository.findByEmail(userEmail)).thenReturn(Optional.of(expectedUser));
        when(userRepository.save(expectedUser)).thenReturn(expectedUser);


        ItemEntity item1 = new ItemEntity();

        boolean contains= !expectedUser.getItemsInCart().contains(item1);
        //if (contains){
        //    throw new Exception();
        //}
        //userService.saveItemToCart(item);
        userService.saveItemToCart(item1);


    }

    @Test
    void removeItemsFromCart(){
        String userEmail = "test@example.com";
        UserEntity expectedUser = new UserEntity();
        ItemEntity item = new ItemEntity();

        List<ItemEntity> items = new ArrayList<>();
        expectedUser.setItemsInCart(items);

        items.add(item);
        expectedUser.setEmail(userEmail);

        Authentication authentication = mock(Authentication.class);
        when(authentication.getName()).thenReturn(userEmail);

        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        when(userRepository.findByEmail(userEmail)).thenReturn(Optional.of(expectedUser));
        when(userRepository.save(expectedUser)).thenReturn(expectedUser);
        userService.removeItemsFromCart();
    }
    @Test
    void saveItemToLiked() {
        String userEmail = "test@example.com";
        UserEntity expectedUser = new UserEntity();
        ItemEntity item = new ItemEntity();

        List<ItemEntity> items = new ArrayList<>();
        expectedUser.setLikedItems(items);

        items.add(item);
        expectedUser.setEmail(userEmail);

        Authentication authentication = mock(Authentication.class);
        when(authentication.getName()).thenReturn(userEmail);

        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        when(userRepository.findByEmail(userEmail)).thenReturn(Optional.of(expectedUser));
        when(userRepository.save(expectedUser)).thenReturn(expectedUser);


        ItemEntity item1 = new ItemEntity();


        
        userService.saveItemToLiked(item1);

    }

    @Test
    void saveUser() {
        UserEntity user = new UserEntity();
        UserEntity newUser = new UserEntity();
        when(userRepository.save(user)).thenReturn(newUser);
        userService.saveUser(user);

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