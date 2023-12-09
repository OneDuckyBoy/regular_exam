package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.ImagesEntity;
import bg.softuni.regular_exam.repositories.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl {
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public ImagesEntity getImageById(int id){
        return imageRepository.getById(id);
    }

}
