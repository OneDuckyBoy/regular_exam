package bg.softuni.regular_exam.models.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImagesEntityTest {

    private ImagesEntity image;
    @BeforeEach
    void before(){
        image=new ImagesEntity();
    }


    @Test
    void setImageLocation() {
        image.setImageLocation("test");
        assertEquals("test",image.getImageLocation());


    }
}