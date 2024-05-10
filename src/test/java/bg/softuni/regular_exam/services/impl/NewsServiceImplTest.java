package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.dto.NewsDTO;
import bg.softuni.regular_exam.models.entity.ImagesEntity;
import bg.softuni.regular_exam.models.entity.NewsEntity;
import bg.softuni.regular_exam.repositories.NewsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class NewsServiceImplTest {
    @Mock
    NewsRepository mockNewsRepository;
    @Mock
    ImageServiceImpl mockImageService;
    NewsServiceImpl newsService;
    @BeforeEach
    void before(){
        newsService = new NewsServiceImpl(mockImageService,mockNewsRepository);
    }
    @Test
    void saveNews() throws IOException {
        NewsDTO newsDTO = new NewsDTO();
        String Path_01 = System.getProperty("user.dir")+"\\build\\resources\\main\\static\\images\\uploads\\";
        File file = new File(Path_01+"testImage.jpeg");
        if (!file.exists()){
            file.createNewFile();
        }
        FileInputStream inputFile = new FileInputStream( Path_01+"testImage.jpeg");
        MockMultipartFile file1 = new MockMultipartFile("file1.jpeg", "testImage.jpeg", "multipart/form-data", inputFile);
        newsDTO.setImage(file1);
        ImagesEntity image = new ImagesEntity();
        Mockito.when(mockImageService.saveImage(file1)).thenReturn(image);
        NewsEntity news = new NewsEntity();
        Mockito.when(mockNewsRepository.findByName(news.getName())).thenReturn(Optional.empty());
        newsService.saveNews(newsDTO);
        assert true;
    }

    @Test
    void getAllNews() {
        List<NewsEntity> allNews = new ArrayList<>();
        Mockito.when(mockNewsRepository.findAll()).thenReturn(allNews);
        assertEquals(allNews,newsService.GetAllNews());
    }

    @Test
    void getNewsById() {
        NewsEntity news = new NewsEntity();
        long id = 1;
        Mockito.when(mockNewsRepository.findById(id)).thenReturn(Optional.of(news));
        assertEquals(news, newsService.getNewsById(id));
    }
}