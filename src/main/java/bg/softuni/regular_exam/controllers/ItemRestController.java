package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.entity.ImagesEntity;
import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.services.impl.ImageServiceImpl;
import bg.softuni.regular_exam.services.impl.ItemServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest")
public class ItemRestController {
    private final ItemServiceImpl itemService;
    private final ImageServiceImpl imageService;

    public ItemRestController(ItemServiceImpl itemService, ImageServiceImpl imageService) {
        this.itemService = itemService;
        this.imageService = imageService;
    }

    @GetMapping(path = "/getItem",produces = "application/json")
    public List<ItemEntity> getItem(){


        return List.of(itemService.getFirstItem());
    }
    @GetMapping(path = "/getAllItems",produces = "application/json")
    public List<ItemEntity> getAllItems(){


        return itemService.getAllItems();
    }


    @GetMapping(path = "/getImage/{id}",produces = "application/json")
    public ImagesEntity getImage(@PathVariable int id){


        return imageService.getImageById(id);
    }



}
