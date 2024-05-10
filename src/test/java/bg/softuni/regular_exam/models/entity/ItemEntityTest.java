package bg.softuni.regular_exam.models.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemEntityTest {

    private ItemEntity item;
    @BeforeEach
    void before(){
        item = new ItemEntity();
    }

    @Test
    void TestConstructorWithParameters(){
        ItemEntity item1 = new ItemEntity("test",20,"asd", new ImagesEntity(), new ItemCategory());
        assertEquals(item1.getName(),"test");
    }

    @Test
    void SetId(){
        item.setId(1L);
        assertEquals(item.getId(), 1L);
    }

    @Test
    void setName() {
        item.setName("test");
        assertEquals("test", item.getName());

    }

    @Test
    void setPrice() {
        item.setPrice(12.3);
        assertEquals(12.3, item.getPrice());

    }

    @Test
    void setDescription() {
        item.setDescription("test");
        assertEquals("test", item.getDescription());
    }

    @Test
    void setImage() {
        ImagesEntity image=new ImagesEntity();
        item.setImage(image);
        assertEquals(image,item.getImage());
    }

    @Test
    void setCategory() {
        ItemCategory category = new ItemCategory();
        item.setCategory(category);
        assertEquals(category,item.getCategory());
    }
}