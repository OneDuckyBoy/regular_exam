package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.ImagesEntity;
import bg.softuni.regular_exam.repositories.ImageRepository;
import bg.softuni.regular_exam.services.ImageService;
import com.sun.jna.platform.win32.WinUser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.Element;
import java.io.*;
import java.util.Random;

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
        String uploadLocation = getClass().getClassLoader().getResource("static/images/uploads").toString()
                // remove file:/ from the beginning
                .substring(6);
        System.out.println("upload location is: " +uploadLocation);
        System.out.println("but it should be: "+System.getProperty("user.dir")+"\\build\\resources\\main\\static\\images\\uploads\\");
        String fileName = file.getOriginalFilename();
        System.out.println("The image name is "+ fileName);
        if (fileName.isEmpty()){
            fileName +=new Random().nextInt();
        }
        //todo if the image is empty, or doesnt have a name it should throw error, or put a default image with default name
        //todo check if adding the same name throws an error
        String Path_01 = System.getProperty("user.dir")+"\\build\\resources\\main\\static\\images\\uploads\\";
        String path = uploadLocation + "/" + fileName;
        System.out.println("the image path is: "+path);

        try (OutputStream os = new FileOutputStream(Path_01+fileName)) {
            os.write(file.getBytes());
        }

        ImagesEntity image = new ImagesEntity();

        image.setImageLocation(
                "images/uploads/"
                +file.getOriginalFilename());
        ImagesEntity img1;
        System.out.println("the image location is: "+ image.getImageLocation());
        var asd = imageRepository.findFirstByImageLocationEndingWith(fileName);
        if (asd.isEmpty()){
            if (!imageRepository.existsById(asd.get().getId())){
                img1 = imageRepository.saveAndFlush(image);

            }
            img1 = imageRepository.findById(asd.get().getId()).get();
        }else {
            img1 = asd.get();
        }
        return img1;
    }

}
