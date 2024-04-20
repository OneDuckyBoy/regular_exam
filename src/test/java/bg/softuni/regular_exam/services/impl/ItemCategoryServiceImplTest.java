package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.ItemCategory;
import bg.softuni.regular_exam.models.enums.CategoriesEnum;
import bg.softuni.regular_exam.models.enums.UserRoleEnum;
import bg.softuni.regular_exam.repositories.ItemCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

class ItemCategoryServiceImplTest {

    ItemCategoryServiceImpl itemCategoryService;

    @Mock
    private ItemCategoryRepository mockItemCategoryRepository;
    @BeforeEach
    void before(){
        itemCategoryService = new ItemCategoryServiceImpl(mockItemCategoryRepository);

    }
    @Test
    void findByCategoryName() {
        ItemCategory category = new ItemCategory();
        category.setCategory(CategoriesEnum.LEDs);
        Mockito.when(mockItemCategoryRepository.findByCategory(CategoriesEnum.LEDs)).thenReturn(category);
        ItemCategory newCategory = (mockItemCategoryRepository.findByCategory(CategoriesEnum.LEDs));
        assertEquals(newCategory,category);

    }
}