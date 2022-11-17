package com.example.eBayLatest.Service;

import com.example.eBayLatest.Model.Item;
import com.example.eBayLatest.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepository repo;

    public Item getItem(int id)  {
        Optional<Item> item = repo.findById(id);
        return item.orElse(null);

    }

    public List<Item> getItems()  {

        return repo.findAll();
    }

    public void saveItem(Item item) {

        repo.save(item);

    }

    public void deleteItem(Item item) {

        repo.delete(item);

    }
}
