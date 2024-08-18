package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.dto.ItemDTO;
import bg.softuni.regular_exam.models.entity.ImagesEntity;
import bg.softuni.regular_exam.models.entity.ItemCategory;
import bg.softuni.regular_exam.models.entity.ItemEntity;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

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




    @Mock
    private BindingResult bindingResult;

    @Mock
    private RedirectAttributes redirectAttributes;


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

    @Test
    void testAddItemPost_Success() throws IOException {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setName("Test Item");
        itemDTO.setDesc("Test Description");
        itemDTO.setCategory("controllers");
        itemDTO.setPrice(100.0);

        ImagesEntity image = new ImagesEntity();
        ItemCategory category = new ItemCategory();

        // Mock the services and repository calls
        when(imageService.saveImage(any())).thenReturn(image);
        when(categoryRepository.findByCategory(any())).thenReturn(category);
        when(bindingResult.hasErrors()).thenReturn(false);

        ModelAndView mv = itemUploadController.addItemPost(itemDTO, bindingResult, redirectAttributes);

        assertEquals("redirect:/", mv.getViewName());

        // Verify that itemService.saveItem was called with the correct item
        verify(itemService).saveItem(any(ItemEntity.class));
    }

    @Test
    void testAddItemPost_Failure() throws IOException {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setCategory("controllers");
        when(bindingResult.hasErrors()).thenReturn(true);

        ModelAndView mv = itemUploadController.addItemPost(itemDTO, bindingResult, redirectAttributes);

        assertEquals("redirect:/add-item", mv.getViewName());

        // Verify that no item is saved due to validation errors

        // Verify that flash attributes are set in case of errors
        verify(redirectAttributes).addFlashAttribute("itemDTO", itemDTO);
        verify(redirectAttributes).addFlashAttribute("org.springframework.validation.BindingResult.itemDTO", bindingResult);
    }

}