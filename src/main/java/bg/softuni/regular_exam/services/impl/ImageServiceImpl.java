package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.ImagesEntity;
import bg.softuni.regular_exam.repositories.ImageRepository;
import bg.softuni.regular_exam.services.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public ImagesEntity getImageById(int id){
        return imageRepository.findById(id);
    }

    @Override
    public ImagesEntity saveImage(MultipartFile file) throws IOException {
//        String path = "src/main/resources/static/images/uploads/"+file.getOriginalFilename();
        String path = "C:\\Users\\stili\\Documents\\Softuni\\Spring Web Advanced\\regular_exam\\src\\main\\resources\\static\\images\\uploads\\"+file.getOriginalFilename();
        File file1 = new File(path);
        try (OutputStream os = new FileOutputStream(file1)) {
            os.write(file.getBytes());
        }

        ImagesEntity image = new ImagesEntity();
        image.setImageLocation("images/uploads/"+file.getOriginalFilename());
        if (imageRepository.findFirstByImageLocationEndingWith(image.getImageLocation()).isEmpty()){

            image = imageRepository.saveAndFlush(image);
        }else {
            image = imageRepository.findFirstByImageLocationEndingWith(image.getImageLocation()).get();
        }
        return image;
    }

}
