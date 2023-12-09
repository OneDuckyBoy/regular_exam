package bg.softuni.regular_exam.repositories;

import bg.softuni.regular_exam.models.entity.ImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImagesEntity,Long> {
    ImagesEntity findById(long id);
}
