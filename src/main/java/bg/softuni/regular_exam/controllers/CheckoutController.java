package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.dto.CheckoutDTO;
import bg.softuni.regular_exam.schedule.Theme;
import bg.softuni.regular_exam.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
public class CheckoutController {
    private final UserService userService;

    public CheckoutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/checkout")
    public ModelAndView checkout(Model model){
        ModelAndView mv = new ModelAndView("/checkout");
        if(!model.containsAttribute("checkoutDTO")){
            model.addAttribute("checkoutDTO",
                    new CheckoutDTO());
        }
        model.addAttribute("darkTheme", Theme.darkTheme);

        double price = userService.GetUserByEmail().getCartPrice();
        if(!model.containsAttribute("price")){
            model.addAttribute("price",
                    price);
        }
        return mv;
    }
    @GetMapping("/cart")
    public String cart(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        double price = 0;
        if(!model.containsAttribute("price")){
            model.addAttribute("price",
                    price);
        }
        return "cart";
    } @PostMapping("/cart")
    public String cartPost(){

        System.out.println();
        return "redirect:/checkout";
    }

    @PostMapping("/checkout")
    public ModelAndView checkoutPost(@Valid @ModelAttribute("checkoutDTO") CheckoutDTO checkoutDTO,
                               BindingResult bindingResult, RedirectAttributes rAtt){

        ModelAndView mv = new ModelAndView("redirect:/thanks_for_purchase/"+ UUID.randomUUID().toString());
//        mv.addObject("purchaseId",43245);



        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("checkoutDTO", checkoutDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.SomeModel", bindingResult);
            return new ModelAndView("/checkout");
        }

        userService.BuyItemsFromCart();
        userService.removeItemsFromCart();

        userService.setUserCartPrice(0);
        return mv;
    }
}
