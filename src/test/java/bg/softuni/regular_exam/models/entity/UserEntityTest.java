package bg.softuni.regular_exam.models.entity;

import bg.softuni.regular_exam.models.enums.UserRoleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    UserEntity user;
    @BeforeEach
    void before(){
        user = new UserEntity();
    }
    @Test
    void TestConstructorWithParameters(){
        UserEntity user1 = new UserEntity("test", "test2");
        assertEquals(user1.getEmail(),"test");
    }
    @Test
    void setEmail() {
        user.setEmail("test");
        assertEquals("test",user.getEmail());
    }

    @Test
    void setPassword() {
        user.setPassword("test");
        assertEquals("test",user.getPassword());
    }

    @Test
    void setCartPrice() {
        user.setCartPrice(12.3);
        assertEquals(12.3,user.getCartPrice());
    }

    @Test
    void setRoles() {
        List<UserRoleEntity> list = new ArrayList<>();
        user.setRoles(list);
        assertEquals(list,user.getRoles());
    }

    @Test
    void setUsername() {
        user.setUsername("test");
        assertEquals("test",user.getUsername());
    }

    @Test
    void setLikedItems() {
        List<ItemEntity> list = new ArrayList<>();
        user.setLikedItems(list);
        assertEquals(list,user.getLikedItems());
    }

    @Test
    void setItemsInCart() {
        List<ItemEntity> list = new ArrayList<>();
        user.setItemsInCart(list);
        assertEquals(list,user.getItemsInCart());
    }

    @Test
    void addToCart() {
        List<ItemEntity> list = new ArrayList<>();
        user.setItemsInCart(list);
        ItemEntity item = new ItemEntity();
        item.setName("test");
        user.AddToCart(item);
        assertEquals(item,user.getItemsInCart().get(0));
    }

    @Test
    void removeFromCart() {
        List<ItemEntity> list = new ArrayList<>();
        user.setItemsInCart(list);
        ItemEntity item = new ItemEntity();
        item.setName("test");
        user.AddToCart(item);
        user.removeFromCart(item);
        assertTrue(user.getItemsInCart().isEmpty());
    }

    @Test
    void addToLiked() {
        List<ItemEntity> list = new ArrayList<>();
        user.setLikedItems(list);
        ItemEntity item = new ItemEntity();
        item.setName("test");
        user.AddToLiked(item);
        assertEquals(item,user.getLikedItems().get(0));
    }

    @Test
    void removeFromLiked() {
        List<ItemEntity> list = new ArrayList<>();
        user.setLikedItems(list);
        ItemEntity item = new ItemEntity();
        item.setName("test");
        user.AddToLiked(item);
        user.removeFromLiked(item);
        assertTrue(user.getLikedItems().isEmpty());
    }

    @Test
    void addRole() {
        List<UserRoleEntity> list = new ArrayList<>();
        user.setRoles(list);
        UserRoleEntity role = new UserRoleEntity();
        role.setRole(UserRoleEnum.USER);
        user.AddRole(role);
        assertEquals(role,user.getRoles().get(0));
    }
}