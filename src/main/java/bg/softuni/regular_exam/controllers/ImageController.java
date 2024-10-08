package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.schedule.Theme;
import bg.softuni.regular_exam.services.FilesStorageService;
import bg.softuni.regular_exam.services.impl.FilesStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    private final FilesStorageService storageService;

    public ImageController(FilesStorageService storageService) {
        this.storageService = storageService;
        storageService.init();
    }
    @GetMapping("/image")
    public String image(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        storageService.init();
        return "image";
    }

    @PostMapping("/image")
    public String img(@RequestParam("imageFile")MultipartFile imageFile){
        return "redirect:/";
    }


}
