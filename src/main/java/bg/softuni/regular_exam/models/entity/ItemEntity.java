package bg.softuni.regular_exam.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.Type;

@Entity
    @Table(name = "items")
    public class ItemEntity extends BaseEntity {
        @Column(name = "name")
        private String name;

        private double price;
        @Column(columnDefinition = "text")
        private String description;
        @OneToOne
        @JoinColumn(name = "image_id")
        private ImagesEntity image;

        @OneToOne()
        @JoinColumn(name = "category_id")
        private ItemCategory category;

    public ItemEntity() {
    }


    public ItemEntity(String name, double price, String description, ImagesEntity image, ItemCategory category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImagesEntity getImage() {
        return image;
    }

    public void setImage(ImagesEntity image) {
        this.image = image;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }
}
