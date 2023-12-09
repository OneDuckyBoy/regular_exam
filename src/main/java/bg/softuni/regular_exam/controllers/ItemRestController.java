package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.services.ItemService;
import bg.softuni.regular_exam.services.impl.ItemServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest-get-item")
public class ItemRestController {
    private final ItemServiceImpl itemService;

    public ItemRestController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @GetMapping(produces = "application/json")
    public List<ItemEntity> getItem(){


        return List.of(itemService.getFirstItem(),itemService.getFirstItem());
    }


}
