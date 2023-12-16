package bg.softuni.regular_exam.repositories;

import bg.softuni.regular_exam.models.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

    Optional<NewsEntity> findByName(String name);
    Optional<NewsEntity> findById(Long id);
}
