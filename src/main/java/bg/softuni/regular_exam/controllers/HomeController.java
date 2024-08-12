package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.models.entity.UserEntity;
import bg.softuni.regular_exam.schedule.Theme;
import bg.softuni.regular_exam.services.ItemService;
import bg.softuni.regular_exam.services.UserService;
import bg.softuni.regular_exam.services.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@ComponentScan("{bg.softuni.regular_exam.services.impl.ItemServiceImpl, bg.softuni.regular_exam.controllers.HomeController}")
@ComponentScan(basePackages={"bg.softuni.regular_exam.services.impl.ItemServiceImpl"})
public class HomeController {

    private final UserService userService;
    private final ItemServiceImpl itemService;

    @Autowired
    public HomeController(UserService userService, ItemServiceImpl itemService) {
        this.userService = userService;
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(auth+"asd");
        if (!auth.getPrincipal().equals("anonymousUser")){
            return "store";
        }
        return "index";
    }


    @GetMapping("/thanks_for_purchase/{purchaseId}")
    public String thanks_for_purchase(Model model, @PathVariable String purchaseId){
        model.addAttribute("darkTheme", Theme.darkTheme);

        if(!model.containsAttribute("purchaseId")){
            model.addAttribute("purchaseId",
                    purchaseId);
        }
        UserEntity user = userService.GetUserByEmail();
        user.setCartPrice(0);
        userService.saveUser(user);
        return "thanks_for_purchase";
    }

    @GetMapping("/liked")
    public String liked(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        List<ItemEntity> liked = userService.GetLikedItemsFromUser();

        if(!model.containsAttribute("liked")){
            model.addAttribute("liked",
                    liked);
        }

        return "liked";
    }


    @GetMapping("/item")///${id}
    public ModelAndView item(Model model
//            @PathVariable("id") int id
    ){
        model.addAttribute("darkTheme", Theme.darkTheme);

        ModelAndView mv= new ModelAndView("Item");
        mv.addObject("IdOfItem"//,id+""
        );
        return mv;
    }
    @GetMapping("/item/{id}")///${id}
    public ModelAndView itemWithId(Model model,
                                   @PathVariable("id") Long id
    ){
        model.addAttribute("darkTheme", Theme.darkTheme);


        model.addAttribute("IdOfItem", id);
        ModelAndView mv= new ModelAndView("Item");
        mv.addObject("IdOfItem", id.toString());
        return mv;
    }
    @GetMapping(path = "/RemoveFromLikedInLikedPage/{id}")
    public  String removeFromLikedInLikedPage(@PathVariable("id") Long id,Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        ItemEntity item = itemService.getItem(id);
        userService.removeItemFromLiked(item);

        return "redirect:/liked";
    }@GetMapping(path = "/RemoveFromLikedInProfilePage/{id}")
    public  String removeFromLikedInProfilePage(@PathVariable("id") Long id,Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        ItemEntity item = itemService.getItem(id);
        userService.removeItemFromLiked(item);

        return "redirect:/user-profile";
    }





}
