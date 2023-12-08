package bg.softuni.regular_exam.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth+"asdasdasd");
        if (!auth.getPrincipal().equals("anonymousUser")){
            return "store";
        }
        return "index";
    }
    @GetMapping("/cart")
    public String cart(){
        return "cart";
    }
    @GetMapping("/checkout")
    public String checkout(){
        return "checkout";
    }
    @GetMapping("/thanks_for_purchase")
    public String thanks_for_purchase(){
        return "thanks_for_purchase";
    }

    @GetMapping("/liked")
    public String liked(){
        return "liked";
    }

    @GetMapping("/user_profile")
    public String user_profile(){
        return "user_profile";
    }
    @GetMapping("/item")
    public String item(){
        return "Item";
    }
    @GetMapping("/add-item")

    public String addItem(){
        return "add-item";
    }
    @GetMapping("/news")

    public String news(){
        return "news";
    }
    @GetMapping("/add-news")

    public String addNews(){
        return "add-news";
    }

    @GetMapping("/news-page")

    public String newsPage(){
        return "news-page";
    }


}
