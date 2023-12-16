package bg.softuni.regular_exam.services;

import bg.softuni.regular_exam.models.entity.ItemEntity;

import java.util.List;

public interface ItemService {

    public List<ItemEntity> getAllItems();
    public ItemEntity getItem(long id);
    public void saveItem(ItemEntity item);

}
