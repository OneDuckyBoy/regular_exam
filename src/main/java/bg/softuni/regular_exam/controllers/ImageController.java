package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.services.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImageController {

    private final FilesStorageService storageService;

    public ImageController(FilesStorageService storageService) {
        this.storageService = storageService;
        storageService.init();
    }
    @GetMapping("/image")
    public String image(){
        storageService.init();
        return "index";
    }


}
