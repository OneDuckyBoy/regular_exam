package bg.softuni.regular_exam.models.dto;

import bg.softuni.regular_exam.models.entity.ImagesEntity;
import bg.softuni.regular_exam.models.enums.CategoriesEnum;

public class ItemDTO {
    private String name;
    private double price;
    private CategoriesEnum category;
    private String desc;
    private ImagesEntity image;
}
