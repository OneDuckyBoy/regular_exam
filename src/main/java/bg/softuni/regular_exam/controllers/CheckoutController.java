package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.dto.CheckoutDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CheckoutController {
    @GetMapping("/checkout")
    public ModelAndView checkout(Model model){
        ModelAndView mv = new ModelAndView("/checkout");
        if(!model.containsAttribute("checkoutDTO")){
            model.addAttribute("checkoutDTO",
                    new CheckoutDTO());
        }
        return mv;
    }@PostMapping("/checkout")
    public ModelAndView checkoutPost(@Valid @ModelAttribute("checkoutDTO") CheckoutDTO checkoutDTO,
                               BindingResult bindingResult, RedirectAttributes rAtt){

        ModelAndView mv = new ModelAndView("redirect:/thanks_for_purchase");

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("checkoutDTO", checkoutDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.SomeModel", bindingResult);
            return new ModelAndView("/checkout");
        }


        return mv;
    }
}
