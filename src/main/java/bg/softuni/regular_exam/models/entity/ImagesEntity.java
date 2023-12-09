package bg.softuni.regular_exam.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "images")

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class ImagesEntity extends BaseEntity{
//    public ItemEntity getItem() {
//        return item;
//    }

//    public void setItem(ItemEntity item) {
//        this.item = item;
//    }

    public ImagesEntity() {
    }

    public ImagesEntity(ItemEntity item, String imageLocation) {
//        this.item = item;
        this.imageLocation = imageLocation;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

//    @JsonIgnore
//    @OneToOne(mappedBy = "image")
//    private ItemEntity item;

    @Column(name = "image_location")
    private String imageLocation;
}
