package bg.softuni.regular_exam.services.impl;

import bg.softuni.regular_exam.models.entity.ItemEntity;
import bg.softuni.regular_exam.repositories.ItemRepository;
import bg.softuni.regular_exam.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@ComponentScan("{bg.softuni.regular_exam.repositories}")
@Service
@Component
public class ItemServiceImpl implements ItemService {
    @Qualifier("itemRepository")
    private final ItemRepository itemRepository;

    @Autowired
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
