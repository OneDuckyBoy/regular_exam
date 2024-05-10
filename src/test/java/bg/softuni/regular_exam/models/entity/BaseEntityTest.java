package bg.softuni.regular_exam.models.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseEntityTest {

    BaseEntity baseEntity;
    @BeforeEach
    void before(){
        baseEntity = new ImagesEntity();

    }
    @Test
    void setId() {
        baseEntity.setId(1L);
        assertEquals(baseEntity.getId(),1L);
    }

    @Test
    void getId() {

        baseEntity.setId(1L);
        assertEquals(baseEntity.getId(),1L);
    }

    @Test
    void testToString() {
    }
}