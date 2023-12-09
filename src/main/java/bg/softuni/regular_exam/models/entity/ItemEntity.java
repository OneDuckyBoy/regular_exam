package bg.softuni.regular_exam.models.entity;

import jakarta.persistence.*;

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


}
