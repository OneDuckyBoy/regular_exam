package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.services.ItemService;
import bg.softuni.regular_exam.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserProfileController {
    private final UserService userService;

    private final ItemService itemService;

    public UserProfileController(UserService userService, ItemService itemService) {
        this.userService = userService;
        this.itemService = itemService;
    }


    @GetMapping("/user-profile")
    public String user_profile(Model model){


        List<ItemEntity> allLiked = userService.GetLikedItemsFromUser().stream()
                .distinct()
                .toList();
        if (!allLiked.isEmpty()){
            List<ItemEntity> liked = new ArrayList<>();
            int counter =0;

            for (ItemEntity itemEntity : allLiked) {
                counter++;
                liked.add(itemEntity);
                if (counter == 3) {
                    break;
                }
            }
            if(!model.containsAttribute("liked")){
                model.addAttribute("liked",
                        liked);
            }
        }

        List<ItemEntity> allCart = userService.GetCartItemsFromUser().stream()
                .distinct()
                .toList();
        if (!allCart.isEmpty()) {
            List<ItemEntity> cart = new ArrayList<>();
            int counter =0;
            for (ItemEntity itemEntity : allCart) {
                counter++;
                cart.add(itemEntity);
                if (counter == 3) {
                    break;
                }
            }

            if (!model.containsAttribute("cart")) {
                model.addAttribute("cart",
                        cart);
            }
        }

        return "user-profile";
    }
    @GetMapping(path = "/RemoveFromCart/{id}")
    public String removeFromCart(@PathVariable("id") Long id){

        ItemEntity item = itemService.getItem(id);
        userService.removeItemFromCart(item);


        return "redirect:/user-profile";
    }
}
