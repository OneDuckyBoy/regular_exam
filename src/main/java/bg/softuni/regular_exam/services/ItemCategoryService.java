package bg.softuni.regular_exam.services;

import bg.softuni.regular_exam.models.entity.ItemCategory;
import bg.softuni.regular_exam.models.enums.CategoriesEnum;

public interface ItemCategoryService {
    public ItemCategory findByCategoryName(CategoriesEnum category);
    public void saveCategory(ItemCategory itemCategory);
}
