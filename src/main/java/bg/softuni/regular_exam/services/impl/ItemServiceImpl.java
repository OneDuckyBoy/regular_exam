package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.repositories.ItemRepository;
import bg.softuni.regular_exam.services.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    public List<ItemEntity> getAllItems(){
        return repository.findAll();
    }
    public ItemEntity getFirstItem(long id){
        ItemEntity item = repository.findById(id);
        return item;
    }
}
