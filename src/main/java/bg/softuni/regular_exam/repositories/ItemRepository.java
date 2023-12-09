package bg.softuni.regular_exam.repositories;

import bg.softuni.regular_exam.models.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long> {

    ItemEntity findById(long id);


}
