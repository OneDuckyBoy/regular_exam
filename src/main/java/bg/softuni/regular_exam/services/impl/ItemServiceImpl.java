package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.repositories.ItemRepository;
import bg.softuni.regular_exam.services.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;

    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    public ItemEntity getFirstItem(){
        ItemEntity item = repository.findById(1);
        return item;
    }
}
