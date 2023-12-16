package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.repositories.ItemRepository;
import bg.softuni.regular_exam.services.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository repository) {
        this.itemRepository = repository;
    }

    @Override
    public List<ItemEntity> getAllItems(){
        return itemRepository.findAll();
    }
    @Override
    public ItemEntity getItem(long id){
        return itemRepository.findById(id);
    }

    @Override
    public void saveItem(ItemEntity item) {
        itemRepository.save(item);
    }
}
