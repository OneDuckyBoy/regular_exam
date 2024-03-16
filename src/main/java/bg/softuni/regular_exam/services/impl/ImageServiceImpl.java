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
        ImagesEntity image = new ImagesEntity();

        image.setImageLocation(
                "images/uploads/"
                        +fileName);
        if (fileName.isEmpty()){
            image =imageRepository.findById(1);//+=new Random().nextInt();
            fileName= image.getImageLocation().replace(    "images/uploads/","");
        }else {
            String Path_01 = System.getProperty("user.dir")+"\\build\\resources\\main\\static\\images\\uploads\\";
            try (OutputStream os = new FileOutputStream(Path_01+fileName)) {
                os.write(file.getBytes());
            }
        }
        ImagesEntity img1;
        var asd = imageRepository.findFirstByImageLocationEndingWith(fileName);
        if (asd.isEmpty()){


                img1 = imageRepository.saveAndFlush(image);

        }else {
            img1 = asd.get();
        }
        return img1;
    }

}
