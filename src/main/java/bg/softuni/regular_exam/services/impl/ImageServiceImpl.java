package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.ImagesEntity;
import bg.softuni.regular_exam.repositories.ImageRepository;
import bg.softuni.regular_exam.services.ImageService;
import com.sun.jna.platform.win32.WinUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.Element;
import java.io.*;
import java.util.Random;
@ComponentScan({"bg.softuni.regular_exam.repositories","bg.softuni.regular_exam.repositories.imageRepository","bg.softuni.regular_exam.models.entity"})
@ComponentScan("{bg.softuni.regular_exam.repositories,bg.softuni.regular_exam.repositories.imageRepository,bg.softuni.regular_exam.models.entity}")

@Service
//@Component
public class ImageServiceImpl implements ImageService {
    @Qualifier("imageRepository")
    private final ImageRepository imageRepository;

    @Autowired
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
        String fileName = file.getOriginalFilename();
        ImagesEntity image = new ImagesEntity();
        image.setImageLocation("images/uploads/" +fileName);
        if (fileName.isEmpty()){
            image =getImageById(1);
            fileName= image.getImageLocation().replace("images/uploads/","");
        }
        else {
            fileName = fileName.hashCode()+"name"+fileName.substring(fileName.lastIndexOf('.'));
            String Path_01 = System.getProperty("user.dir")+"\\build\\resources\\main\\static\\images\\uploads\\";
            try (OutputStream os = new FileOutputStream(Path_01+fileName)) {
                os.write(file.getBytes());
            }
        }
        ImagesEntity img1;
        image.setImageLocation("images/uploads/"+fileName);
        var asd = imageRepository.findFirstByImageLocationEndingWith(fileName);
        if (asd.isEmpty()){
         img1 = imageRepository.saveAndFlush(image);

        }
        else {
            img1 = asd.get();
        }
       return img1;
    }

}
