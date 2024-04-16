package bg.softuni.regular_exam.models.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NewsDTOTest {

    private NewsDTO dummyNews;
    private String dummyName= "test name";
    private String dummyDescription= "test description";

    private String originalImageName = "test original image name";
    private String imageName = "test image name";
    final MultipartFile mockFile = mock(MultipartFile.class);

    @BeforeEach
    void setUp() {
        when(mockFile.getOriginalFilename()).thenReturn(originalImageName);
        when(mockFile.getName()).thenReturn(imageName);

        dummyNews = new NewsDTO();
        dummyNews.setName(dummyName);
        dummyNews.setDescription(dummyDescription);
        dummyNews.setImage(mockFile);
    }

    @Test
    void getName() {
        assertEquals(dummyName,dummyNews.getName());
    }

    @Test
    void setName() {
        dummyNews.setName(imageName);
        assertEquals(imageName,dummyNews.getName());

    }

    @Test
    void getDescription() {
        assertEquals(dummyDescription,dummyNews.getDescription());

    }

    @Test
    void setDescription() {
        dummyNews.setDescription(imageName);
        assertEquals(imageName,dummyNews.getDescription());
    }

    @Test
    void getImage() {
        assertEquals(mockFile,dummyNews.getImage());
    }

    @Test
    void setImage() {
        dummyNews.setImage(mockFile);
        assertEquals(mockFile,dummyNews.getImage());


    }
}