package bg.softuni.regular_exam.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "images")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImagesEntity extends BaseEntity{

    @OneToOne(mappedBy = "image")
    private ItemEntity item;

    @Column(name = "image_location")
    private String imageLocation;
}
