package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.schedule.Theme;
import bg.softuni.regular_exam.services.ItemService;
import bg.softuni.regular_exam.services.UserService;
import bg.softuni.regular_exam.services.impl.ItemServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

 @ExtendWith(SpringExtension.class)
@SpringBootTest
@ComponentScan({"bg.softuni.regular_exam.services.impl.ItemServiceImpl","bg.softuni.regular_exam.services.impl", "bg.softuni.regular_exam.controllers.ItemRestController"})
//@WebMvcTest(
//        HomeController.class
//)
@AutoConfigureMockMvc
class HomeControllerTest {

     @Mock
     private UserService userService;

     @Mock
     private ItemServiceImpl itemService;

     @InjectMocks
     private HomeController homeController;

     @BeforeEach
     void setUp() {
         MockitoAnnotations.openMocks(this);

         Theme.darkTheme = true;
     }

     @Test
     void testHome_AuthenticatedUser() {
         // Given
         Authentication auth = mock(Authentication.class);
         when(auth.getPrincipal()).thenReturn("user");  // Simulate an authenticated user
         SecurityContextHolder.getContext().setAuthentication(auth);

         Model model = mock(Model.class);

         // When
         String viewName = homeController.home(model);

         // Then
         assertEquals("store", viewName);
     }

     @Test
     void testHome_AnonymousUser() {
         // Given
         Authentication auth = mock(Authentication.class);
         when(auth.getPrincipal()).thenReturn("anonymousUser");  // Simulate an anonymous user
         SecurityContextHolder.getContext().setAuthentication(auth);

         Model model = mock(Model.class);

         // When
         String viewName = homeController.home(model);

         // Then
         assertEquals("index", viewName);
     }



//     @Test
//     void testThanksForPurchase() {
//         String purchaseId = "12345";
//         Model model = mock(Model.class);
//         UserEntity user = mock(UserEntity.class);
//        user.setCartPrice(0);
//        user.setEmail("test@gmail.com");
//         when(userService.GetUserByEmail()).thenReturn(user);
//       // UserEntity user2 = userService.GetUserByEmail();
//         System.out.println();
//         when(model.containsAttribute("purchaseId")).thenReturn(false);
//
//         String viewName = homeController.thanks_for_purchase(model, purchaseId);
//
//         assertEquals("thanks_for_purchase", viewName);
//
//         verify(model).addAttribute("darkTheme", Theme.darkTheme);
//
//         ArgumentCaptor<String> purchaseIdCaptor = forClass(String.class);
//         verify(model).addAttribute(eq("purchaseId"), purchaseIdCaptor.capture());
//         assertEquals(purchaseId, purchaseIdCaptor.getValue());
//
//     }


     @Test
     void testLiked() {
         Model model = mock(Model.class);
         List<ItemEntity> likedItems = mock(List.class);

         when(userService.GetLikedItemsFromUser()).thenReturn(likedItems);
         when(model.containsAttribute("liked")).thenReturn(false);
         likedItems.add(new ItemEntity());
         String viewName = homeController.liked(model);

         assertEquals("liked", viewName);

         verify(model).addAttribute("darkTheme", Theme.darkTheme);

         ArgumentCaptor<List> likedCaptor = forClass(List.class);
         verify(model).addAttribute(eq("liked"), likedCaptor.capture());

     }

     @Test
     void testItem() {
         Model model = mock(Model.class);

         ModelAndView mv = homeController.item(model);

         assertEquals("Item", mv.getViewName());

         // Check if "IdOfItem" is correctly added
         assertEquals(null, mv.getModel().get("IdOfItem"));  // No ID should be set in this method
     }

     @Test
     void testItemWithId() {
         Model model = mock(Model.class);
         Long id = 123L;

         ModelAndView mv = homeController.itemWithId(model, id);

         assertEquals("Item", mv.getViewName());
         assertEquals(id.toString(), mv.getModel().get("IdOfItem"));

         // Verify ID added to model
         assertEquals(id.toString(), mv.getModel().get("IdOfItem"));
     }
     @Test
     void testRemoveFromLikedInLikedPage() {
         Long id = 123L;
         Model model = mock(Model.class);

         String viewName = homeController.removeFromLikedInLikedPage(id, model);

         assertEquals("redirect:/liked", viewName);

     }

     @Test
     void testRemoveFromLikedInProfilePage() {
         Long id = 123L;
         Model model = mock(Model.class);
//         ItemEntity item = mock(ItemEntity.class);
//
//         when(itemService.getItem(id)).thenReturn(item);

         String viewName = homeController.removeFromLikedInProfilePage(id, model);

         assertEquals("redirect:/user-profile", viewName);

//         verify(itemService).getItem(id);
//         verify(userService).removeItemFromLiked(item);
     }


}