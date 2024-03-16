package bg.softuni.regular_exam.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "news")

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class NewsEntity extends BaseEntity{

    @Column
    private String name;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name = "image_id")
    private ImagesEntity image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
