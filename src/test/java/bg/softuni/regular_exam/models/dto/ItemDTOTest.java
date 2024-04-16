package bg.softuni.regular_exam.models.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ItemDTOTest {

    private ItemDTO itemDTO;
    private final String name ="dummy name";
    private final double price=20;
    private final String category="dummy category";
    private final String desc ="dummy desc";
    private final  MultipartFile image = mock(MultipartFile.class);


    @BeforeEach
    void setUp() {
        String originalImageName = "test original image name";
        when(image.getOriginalFilename()).thenReturn(originalImageName);
        String imageName = "test image name";
        when(image.getName()).thenReturn(imageName);

        itemDTO =new ItemDTO();
        itemDTO.setName(name);
        itemDTO.setDesc(desc);
        itemDTO.setPrice(price);
        itemDTO.setCategory(category);
        itemDTO.setImage(image);
    }

    @Test
    void getName() {
        assertEquals(name,itemDTO.getName());

    }

    @Test
    void setName() {
        itemDTO.setName(desc);
        assertEquals(desc,itemDTO.getName());
    }

    @Test
    void getPrice() {
        assertEquals(price,itemDTO.getPrice());

    }

    @Test
    void setPrice() {
        itemDTO.setPrice(5);
        assertEquals(5,itemDTO.getPrice());

    }

    @Test
    void getCategory() {
        assertEquals(category,itemDTO.getCategory());

    }

    @Test
    void setCategory() {
        itemDTO.setCategory(name);
        assertEquals(name,itemDTO.getCategory());

    }

    @Test
    void getDesc() {
        assertEquals(desc,itemDTO.getDesc());
    }

    @Test
    void setDesc() {
        itemDTO.setDesc(name);
        assertEquals(name,itemDTO.getDesc());

    }

    @Test
    void getImage() {
        assertEquals(image,itemDTO.getImage());

    }

    @Test
    void setImage() {
        itemDTO.setImage(image);
        assertEquals(image,itemDTO.getImage());

    }
}