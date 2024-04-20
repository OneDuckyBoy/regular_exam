package bg.softuni.regular_exam.models.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsEntityTest {

    NewsEntity news;

    @BeforeEach
    void before(){
        news = new NewsEntity();
    }
    @Test
    void setName() {
        news.setName("test");
        assertEquals("test", news.getName());

    }
    @Test
    void setDescription() {
        news.setDescription("test");
        assertEquals("test", news.getDescription());
    }

    @Test
    void setImage() {
        ImagesEntity image=new ImagesEntity();
        news.setImage(image);
        assertEquals(image, news.getImage());
    }
}