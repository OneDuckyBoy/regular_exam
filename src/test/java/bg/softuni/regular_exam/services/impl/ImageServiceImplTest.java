package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.ImagesEntity;
import bg.softuni.regular_exam.models.enums.CategoriesEnum;
import bg.softuni.regular_exam.repositories.ImageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class ImageServiceImplTest {

    @Mock
    ImageRepository mockImageRepository;
    ImageServiceImpl imageService;
    @BeforeEach
    void before(){
        imageService = new ImageServiceImpl(mockImageRepository);
    }
    @Test
    void getImageById() {
        int id = 1;
        ImagesEntity image = new ImagesEntity("test");
        Mockito.when(mockImageRepository.findById(id)).thenReturn(image);
        ImagesEntity newImage = imageService.getImageById(id);
        assertEquals(newImage,image);

    }

    @Test
    void saveImage() throws IOException {
        //Mockito.when().thenReturn();
        String Path_01 = System.getProperty("user.dir")+"\\build\\resources\\main\\static\\images\\uploads\\";
        File file2 = new File(Path_01+"testImage.jpeg");
        if (!file2.exists()){
            file2.createNewFile();
        }
        FileInputStream inputFile = new FileInputStream( Path_01+"testImage.jpeg");
        MockMultipartFile file1 = new MockMultipartFile("file1.jpeg", "testImage.jpeg", "multipart/form-data", inputFile);
        imageService.saveImage(file1);

        File file = new File(Path_01+"testImage.jpeg");

        assertTrue(file.exists());
        file.delete();
    }
}