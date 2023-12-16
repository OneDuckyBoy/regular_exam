package bg.softuni.regular_exam.services;


import bg.softuni.regular_exam.models.dto.NewsDTO;
import bg.softuni.regular_exam.models.entity.NewsEntity;

import java.io.IOException;
import java.util.List;

public interface NewsService {

    public void saveNews(NewsDTO newsDTO) throws IOException;
    public List<NewsEntity> GetAllNews();
    public NewsEntity getNewsById(Long id);
}
