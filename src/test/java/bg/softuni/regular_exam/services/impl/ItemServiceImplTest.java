package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.repositories.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {

    @Mock
    ItemRepository mockItemRepository;
    ItemServiceImpl itemService;
    @BeforeEach
    void before(){
        itemService = new ItemServiceImpl(mockItemRepository);

    }
    @Test
    void getAllItems() {
        List<ItemEntity> items = new ArrayList<>();
        Mockito.when(mockItemRepository.findAll()).thenReturn(items);
        assertEquals(itemService.getAllItems(), items);

    }

    @Test
    void getItem() {
        List<ItemEntity> items = new ArrayList<>();
        ItemEntity item = new ItemEntity();
        Mockito.when(mockItemRepository.findById(1)).thenReturn(item);
        assertEquals(itemService.getItem(1), item);
    }

    @Test
    void saveItem() {
        ItemEntity item = new ItemEntity();
        Mockito.when(mockItemRepository.save(item)).thenReturn(item);
        itemService.saveItem(item);
    }
}