package bg.softuni.regular_exam.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(auth+"asd");
        if (!auth.getPrincipal().equals("anonymousUser")){
            return "store";
        }
        return "index";
    }
    @GetMapping("/cart")
    public String cart(){
        return "cart";
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
    @GetMapping("/item")///${id}
    public ModelAndView item(
//            @PathVariable("id") int id
    ){
        ModelAndView mv= new ModelAndView("Item");
        mv.addObject("IdOfItem"//,id+""
        );
        return mv;
    }
    @GetMapping("/item/{id}")///${id}
    public ModelAndView itemWithId(Model model,
                                   @PathVariable("id") Long id
    ){
        model.addAttribute("IdOfItem", id);
        ModelAndView mv= new ModelAndView("Item");
        mv.addObject("IdOfItem", id.toString());
        return mv;
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
