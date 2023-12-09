package bg.softuni.regular_exam.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "images")
public class ImagesEntity extends BaseEntity{

    @OneToOne(mappedBy = "image")
    private ItemEntity item;

    @Column(name = "image_location")
    private String imageLocation;
}
