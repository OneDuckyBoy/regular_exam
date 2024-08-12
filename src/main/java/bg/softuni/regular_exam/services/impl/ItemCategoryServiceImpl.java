package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.ItemCategory;
import bg.softuni.regular_exam.models.enums.CategoriesEnum;
import bg.softuni.regular_exam.repositories.ItemCategoryRepository;
import bg.softuni.regular_exam.services.ItemCategoryService;
import org.springframework.stereotype.Service;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {
    private final ItemCategoryRepository categoryRepository;

    public ItemCategoryServiceImpl(ItemCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ItemCategory findByCategoryName(CategoriesEnum category) {
        return categoryRepository.findByCategory(category);
    }

    @Override
    public void saveCategory(ItemCategory itemCategory) {
        categoryRepository.save(itemCategory);
    }
}
