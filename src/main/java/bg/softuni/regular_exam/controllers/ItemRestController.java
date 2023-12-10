package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.services.impl.ItemServiceImpl;
import bg.softuni.regular_exam.services.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rest")
public class ItemRestController {
    private final ItemServiceImpl itemService;
    private final UserServiceImpl userService;


    public ItemRestController(ItemServiceImpl itemService, UserServiceImpl userService) {
        this.itemService = itemService;
        this.userService = userService;
    }

    @GetMapping(path = "/getItem/{id}",produces = "application/json")
    public ItemEntity getItem(@PathVariable("id") Long id){


        return itemService.getItem(id);
    }@GetMapping(path = "/getIfItemIsLiked/{id}",produces = "application/json")
    public boolean getIfItemIsLiked(@PathVariable("id") Long id){


        return userService.GetUserByEmail().getLikedItems().contains(itemService.getItem(id));
    }


    @GetMapping(path = "/getAllItems",produces = "application/json")
    public List<ItemEntity> getAllItems(){


        return itemService.getAllItems();
    }
    @GetMapping(path = "/addToCart/{id}")
    @ResponseBody
    public Map<String, String> addToCart(@PathVariable("id") Long id){

        System.out.println("test asd "+id);

        ItemEntity item = itemService.getItem(id);
        userService.saveItemToCart(item);


        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Action completed successfully");
        return response;
    }

    @GetMapping(path = "/addToLiked/{id}")
    @ResponseBody
    public Map<String, String> addToLiked(@PathVariable("id") Long id){

//        System.out.println("test asd "+id);

        ItemEntity item = itemService.getItem(id);
        userService.saveItemToLiked(item);


        System.out.println("dsa");

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Action completed successfully");
        return response;
    }@GetMapping(path = "/RemoveFromLiked/{id}")
    @ResponseBody
    public Map<String, String> removeFromLiked(@PathVariable("id") Long id){

//        System.out.println("test asd "+id);

        ItemEntity item = itemService.getItem(id);
        userService.removeItemFromLiked(item);
//        UserEntity user = userService.GetUserByEmail();
//       user.removeFromLiked(item);
//        userService.saveUser(user);

        System.out.println("asd");

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Action completed successfully");
        return response;
    }

}
