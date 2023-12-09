package bg.softuni.regular_exam.models.entity;

import jakarta.persistence.*;

    @Entity
    @Table(name = "items")
    public class ItemEntity extends BaseEntity {
        @Column(name = "name")
        private String name;

        private double price;
        @OneToOne
        @JoinColumn(name = "image_id")
        private ImagesEntity image;

        @OneToOne()
        @JoinColumn(name = "category_id")
        private ItemCategory category;


}
