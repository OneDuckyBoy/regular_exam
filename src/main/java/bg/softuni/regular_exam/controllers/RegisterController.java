package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.dto.UserRegisterDTO;
import bg.softuni.regular_exam.schedule.Theme;
import bg.softuni.regular_exam.services.UserService;
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
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView register(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        ModelAndView mv = new ModelAndView("/register");
        if(!model.containsAttribute("registerDTO")){
            model.addAttribute("registerDTO",
                    new UserRegisterDTO());
        }
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("registerDTO")  UserRegisterDTO registerDTO,
                                 BindingResult bindingResult, RedirectAttributes rAtt){



        ModelAndView mv = new ModelAndView("redirect:/login");

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("registerDTO", registerDTO);
            rAtt.addFlashAttribute(
                    "org.springframework.validation.BindingResult.SomeModel", bindingResult);
            return new ModelAndView("/register");
        }

        userService.register(registerDTO);

        return mv;
    }

}
