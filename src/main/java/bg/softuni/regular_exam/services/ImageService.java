package bg.softuni.regular_exam.services;

import bg.softuni.regular_exam.models.entity.ImagesEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ImageService {
    public ImagesEntity getImageById(int id);

    public ImagesEntity saveImage(MultipartFile file) throws IOException;
}
