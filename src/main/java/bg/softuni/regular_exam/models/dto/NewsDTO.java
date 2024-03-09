package bg.softuni.regular_exam.models.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class NewsDTO {


    @Length(min =2,message = "The news name must more than 2 letters!")
    private String name;
    @Length(min =2,message = "The news description must more than 2 letters!")
    private String description;
//    @NotEmpty(message = "The image cannot be blank!")
    private MultipartFile image;

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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
