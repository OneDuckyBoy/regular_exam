package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.schedule.Theme;
import bg.softuni.regular_exam.services.ItemService;
import bg.softuni.regular_exam.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        model.addAttribute("darkTheme", Theme.darkTheme);


        List<ItemEntity> allLiked = userService.GetLikedItemsFromUser().stream()
                .distinct()
                .toList();
        List<ItemEntity> liked = new ArrayList<>();

        if (!allLiked.isEmpty()){
            int counter =0;

            for (ItemEntity itemEntity : allLiked) {
                counter++;
                liked.add(itemEntity);
                if (counter == 3) {
                    break;
                }
            }

        }
        if(!model.containsAttribute("liked")){
            model.addAttribute("liked",
                    liked);
        }

        List<ItemEntity> allCart = userService.GetCartItemsFromUser().stream()
                .distinct()
                .toList();
        List<ItemEntity> cart = new ArrayList<>();

        if (!allCart.isEmpty()) {
            int counter =0;
            for (ItemEntity itemEntity : allCart) {
                counter++;
                cart.add(itemEntity);
                if (counter == 3) {
                    break;
                }
            }


        }
        if (!model.containsAttribute("cart")) {
            model.addAttribute("cart",
                    cart);
        }
        Optional<UserEntity> userEntity = userService.GetUserByEmailOptional();
        boolean present = userEntity.isPresent();
        model.addAttribute("present",present);
        if (present)
        model.addAttribute("user",userEntity.get());

        return "user-profile";
    }
    @GetMapping(path = "/RemoveFromCart/{id}")
    public String removeFromCart(@PathVariable("id") Long id, Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        ItemEntity item = itemService.getItem(id);
        userService.removeItemFromCart(item);


        return "redirect:/user-profile";
    }@GetMapping(path = "/change-username")
    public String changeUsername( Model model){
        String username ="";
        model.addAttribute("username",username);
        model.addAttribute("darkTheme", Theme.darkTheme);



        return "/change-username";
    }@PostMapping(path = "/change-username")
    public String changeUsernamePost(@RequestParam("username")String username , Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);
        UserEntity user = userService.GetUserByEmail();
        user.setUsername(username);
        userService.saveUser(user);


        return "redirect:/user-profile";
    }

}
