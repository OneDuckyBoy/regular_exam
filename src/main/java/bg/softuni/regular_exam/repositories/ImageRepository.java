package bg.softuni.regular_exam.repositories;

import bg.softuni.regular_exam.models.entity.ImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImagesEntity,Long> {
    ImagesEntity findById(long id);
    Optional<ImagesEntity> findFirstByImageLocationEndingWith(String name);
}
