package bg.softuni.regular_exam.models.dto;

import bg.softuni.regular_exam.models.entity.ImagesEntity;
import bg.softuni.regular_exam.models.enums.CategoriesEnum;
import org.springframework.web.multipart.MultipartFile;

public class ItemDTO {
    private String name;
    private double price;
    private String category;
    private String desc;
    private MultipartFile image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
