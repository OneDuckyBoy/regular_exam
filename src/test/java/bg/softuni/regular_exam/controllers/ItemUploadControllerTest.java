package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.dto.ItemDTO;
import bg.softuni.regular_exam.repositories.ItemCategoryRepository;
import bg.softuni.regular_exam.schedule.Theme;
import bg.softuni.regular_exam.services.ImageService;
import bg.softuni.regular_exam.services.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemUploadControllerTest {

    @Mock
    private ImageService imageService;

    @Mock
    private ItemCategoryRepository categoryRepository;

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemUploadController itemUploadController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddItem() {
        Model model = mock(Model.class);

        // Simulate the case where "itemDTO" is not already in the model
        when(model.containsAttribute("itemDTO")).thenReturn(false);

        ModelAndView mv = itemUploadController.addItem(model);

        assertEquals("/add-item", mv.getViewName());

        // Verify that "itemDTO" is added to the model
//        verify(model).addAttribute("itemDTO", new ItemDTO());

        // Verify the "darkTheme" attribute is added
//        verify(model).addAttribute("darkTheme", Theme.darkTheme);
    }
}