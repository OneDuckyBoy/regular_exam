package bg.softuni.regular_exam.controllers;


import bg.softuni.regular_exam.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping(path = "/setCartPrice/{price}")

    public Map<String, String> addToCart(@PathVariable("price") double price){

        userService.setUserCartPrice(price);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Action completed successfully");
        return response;
    }

}
