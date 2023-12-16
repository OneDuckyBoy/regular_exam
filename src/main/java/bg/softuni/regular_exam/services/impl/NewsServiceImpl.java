package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.dto.NewsDTO;
import bg.softuni.regular_exam.models.entity.ImagesEntity;
import bg.softuni.regular_exam.models.entity.NewsEntity;
import bg.softuni.regular_exam.repositories.NewsRepository;
import bg.softuni.regular_exam.services.ImageService;
import bg.softuni.regular_exam.services.NewsService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    private final ImageService imageService;
    private final NewsRepository newsRepository;

    public NewsServiceImpl(ImageService imageService, NewsRepository newsRepository) {
        this.imageService = imageService;
        this.newsRepository = newsRepository;
    }

    @Override
    public void saveNews(NewsDTO newsDTO) throws IOException {
        System.out.println();
        ImagesEntity image = imageService.saveImage(newsDTO.getImage());
        NewsEntity news = new NewsEntity();
        news.setName(newsDTO.getName());
        news.setDescription(newsDTO.getDescription());
        news.setImage(image);

        if (newsRepository.findByName(news.getName()).isEmpty()){
            newsRepository.save(news);
        }

    }

    @Override
    public List<NewsEntity> GetAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public NewsEntity getNewsById(Long id) {
        return newsRepository.findById(id).get();
    }
}
