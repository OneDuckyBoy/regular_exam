package bg.softuni.regular_exam.repositories;

import bg.softuni.regular_exam.models.entity.ItemCategory;
import bg.softuni.regular_exam.models.enums.CategoriesEnum;
import bg.softuni.regular_exam.services.ItemCategoryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Long> {
    ItemCategory findByCategory(CategoriesEnum category);
}
