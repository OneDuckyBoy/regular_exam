package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.dto.ItemDTO;
import bg.softuni.regular_exam.models.entity.ImagesEntity;
import bg.softuni.regular_exam.models.entity.ItemCategory;
import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.models.enums.CategoriesEnum;
import bg.softuni.regular_exam.repositories.ItemCategoryRepository;
import bg.softuni.regular_exam.schedule.Theme;
import bg.softuni.regular_exam.services.ImageService;
import bg.softuni.regular_exam.services.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.*;

@Controller
public class ItemUploadController {

    private final ImageService imageService;
    private final ItemCategoryRepository categoryRepository;

    private final ItemService itemService;

    @Autowired
    private HttpServletRequest request;
    public ItemUploadController(ImageService imageService, ItemCategoryRepository categoryRepository, ItemService itemService) {
        this.imageService = imageService;
        this.categoryRepository = categoryRepository;
        this.itemService = itemService;
    }

    @GetMapping("/add-item")

    public ModelAndView addItem(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);


        ModelAndView mv = new ModelAndView("/add-item");
        if(!model.containsAttribute("itemDTO")){
            model.addAttribute("itemDTO",
                    new ItemDTO());
        }
        return mv;
    }

    @PostMapping("/add-item")
    private ModelAndView addItemPost(
                                     @Valid ItemDTO itemDTO,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes

    ) throws IOException {
//        MultipartFile file = itemDTO.getImage();
//        String path = "src/main/resources/static/images/uploads/"+file.getOriginalFilename();
//        File file1 = new File(path);
//        try (OutputStream os = new FileOutputStream(file1)) {
//            os.write(file.getBytes());
//        }
        ImagesEntity image = imageService.saveImage(itemDTO.getImage());


        ItemCategory category = categoryRepository.findByCategory(CategoriesEnum.valueOf(itemDTO.getCategory()));

        ItemEntity item = new ItemEntity();
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDesc());
        item.setCategory(category);
        item.setPrice(itemDTO.getPrice());
        item.setImage(image);

        System.out.println();
        itemService.saveItem(item);

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("itemDTO", itemDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemDTO", bindingResult);

            return new ModelAndView("redirect:/add-item");
        }

        return new ModelAndView("redirect:/");
    }


}
