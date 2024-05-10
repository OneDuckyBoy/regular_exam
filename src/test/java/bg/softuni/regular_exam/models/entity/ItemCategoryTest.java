package bg.softuni.regular_exam.models.entity;

import bg.softuni.regular_exam.models.enums.CategoriesEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemCategoryTest {

    private ItemCategory category;
    @BeforeEach
    void  before(){
        category=new ItemCategory();
    }


    @Test
    void setCategory() {
        category.setCategory(CategoriesEnum.Displays);
        category.setCategory(CategoriesEnum.cablesAndOthers);
        category.setCategory(CategoriesEnum.sensors);
        category.setCategory(CategoriesEnum.controllers);
        category.setCategory(CategoriesEnum.LEDs);
        assertEquals(CategoriesEnum.LEDs,category.getCategory());

    }



    @Test
    void setItem() {
        List<ItemEntity> list = new ArrayList<>();
        category.setItem(list);
        assertEquals(list, category.getItem());

    }

    @Test
    void getCategory() {

        category.setCategory(CategoriesEnum.LEDs);
        assertEquals(CategoriesEnum.LEDs,category.getCategory());
    }

    @Test
    void getItem() {
        List<ItemEntity> list = new ArrayList<>();
        category.setItem(list);
        assertEquals(list, category.getItem());
    }
}