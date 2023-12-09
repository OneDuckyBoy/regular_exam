package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.dto.ItemDTO;
import bg.softuni.regular_exam.models.dto.UserRegisterDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemUploadController {

    @GetMapping("/add-item")

    public ModelAndView addItem(Model model){

        ModelAndView mv = new ModelAndView("redirect:/");
        if(!model.containsAttribute("registerDTO")){
            model.addAttribute("registerDTO",
                    new ItemDTO());
        }
        return mv;
    }

    @PostMapping("/add-item")
    private ModelAndView addItemPost(){


        return new ModelAndView("redirect:/");
    }


}
