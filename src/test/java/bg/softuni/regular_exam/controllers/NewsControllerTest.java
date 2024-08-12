package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.dto.NewsDTO;
import bg.softuni.regular_exam.models.entity.NewsEntity;
import bg.softuni.regular_exam.schedule.Theme;
import bg.softuni.regular_exam.services.ImageService;
import bg.softuni.regular_exam.services.NewsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
class NewsControllerTest {

    @Mock
    private ImageService imageService;

    @Mock
    private Model model;
    @Mock
    private NewsService newsService;

    @InjectMocks
    private NewsController newsController;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private RedirectAttributes redirectAttributes;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Theme.darkTheme = true;  // Set Theme.darkTheme to true for the test
    }

    @Test
    void testNews() {
        Model model = mock(Model.class);
        List<NewsEntity> news = mock(List.class);

        when(newsService.GetAllNews()).thenReturn(news);
        when(model.containsAttribute("news")).thenReturn(false);

        String viewName = newsController.news(model);

        assertEquals("news", viewName);

    }

    @Test
    void testAddNews() {
        Model model = mock(Model.class);

        // Simulate the case where "newsDTO" is not already in the model
        when(model.containsAttribute("newsDTO")).thenReturn(false);

        String viewName = newsController.addNews(model);

        assertEquals("add-news", viewName);

    }

    @Test
    void testAddNewsPost_Success() throws IOException {
        NewsDTO newsDTO = new NewsDTO();

        // Simulate that there are no binding errors
        when(bindingResult.hasErrors()).thenReturn(false);

        ModelAndView mv = newsController.addNewsPost(newsDTO, bindingResult, redirectAttributes);

        assertEquals("redirect:/news", mv.getViewName());

    }

    @Test
    void testAddNewsPost_Failure() throws IOException {
        NewsDTO newsDTO = new NewsDTO();

        // Simulate that there are binding errors
        when(bindingResult.hasErrors()).thenReturn(true);

        ModelAndView mv = newsController.addNewsPost(newsDTO, bindingResult, redirectAttributes);

        assertEquals("redirect:/add-news", mv.getViewName());

        // Verify that saveNews was not called due to validation errors
        verifyNoInteractions(newsService);

        // Verify that flash attributes are set in case of errors
        verify(redirectAttributes).addFlashAttribute("newsDTO", newsDTO);
        verify(redirectAttributes).addFlashAttribute("org.springframework.validation.BindingResult.newsDTO", bindingResult);
    }

    @Test
    void testNewsPage() {
        String viewName = newsController.newsPage(model);

        assertEquals("news-page", viewName);

        // Verify the "darkTheme" attribute is added
        verify(model).addAttribute("darkTheme", Theme.darkTheme);
    }

    @Test
    void testNewsPage1() {
        Long id = 1L;
        NewsEntity news = new NewsEntity();

        // Mock the behavior of newsService.getNewsById
        when(newsService.getNewsById(id)).thenReturn(news);

        // Mock the behavior of model.containsAttribute
        when(model.containsAttribute("news")).thenReturn(false);

        String viewName = newsController.newsPage1(id, model);

        assertEquals("news-page", viewName);


    }
}