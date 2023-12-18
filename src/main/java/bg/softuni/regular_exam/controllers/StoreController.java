package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.schedule.Theme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreController {

    @GetMapping("/controllers")
    public ModelAndView categories(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        ModelAndView mv = new ModelAndView("redirect:/");
        model.addAttribute("category","5");
        mv.addObject("category", "5");
        return mv;
    }
    @GetMapping("/sensors")
    public ModelAndView sensors(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        ModelAndView mv = new ModelAndView("redirect:/");
        model.addAttribute("category","4");
        mv.addObject("category", "4");
        return mv;
    }
    @GetMapping("/LEDs")
    public ModelAndView LEDs(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        ModelAndView mv = new ModelAndView("redirect:/");
        model.addAttribute("category","3");
        mv.addObject("category", "3");
        return mv;
    }
    @GetMapping("/Displays")
    public ModelAndView Displays(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        ModelAndView mv = new ModelAndView("redirect:/");
        model.addAttribute("category","2");
        mv.addObject("category", "2");
        return mv;
    }
    @GetMapping("/cablesAndOthers")
    public ModelAndView cablesAndOthers(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        ModelAndView mv = new ModelAndView("redirect:/");
        model.addAttribute("category","1");
        mv.addObject("category", "1");
        return mv;
    }


}
