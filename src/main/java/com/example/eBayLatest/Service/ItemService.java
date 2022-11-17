package com.example.eBayLatest.Service;

import com.example.eBayLatest.Model.Item;
import com.example.eBayLatest.Model.ValidationError;
import com.example.eBayLatest.Repository.ItemRepository;
import com.example.eBayLatest.ServiceExternal.NormalizeItemInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepository repo;
    @Autowired
    ValidateItemDefault validateItemDefault;
    @Autowired
    ShouldValidateItemDefault shouldValidateItemDefault;
    @Autowired
    NormalizeItemInput normalizeInput;

    public List<ValidationError> validateItem(Item item) {

        // We always normalize itemSpecific at the top of the method as IShouldValidate may reference item specifics
        Map<String, String> itemSpecificMap = normalizeInput.normalizeItemSpecific(item.getItemSpecifics());
        item.setItemSpecificMap(itemSpecificMap);

        if (!shouldValidate(item, shouldValidateItemDefault )) {
            System.out.println("Validation is not required for item: "+ item.getTitle());
            return new ArrayList<>();
        }

        List<ValidationError> list = validate(item, validateItemDefault);
        return list;
    }

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

    // Accepts different IShouldValidateItem implementations
    private boolean shouldValidate(Item item, IShouldValidateItem shouldValidateItem) {
        return shouldValidateItem.shouldValidateItem(item);
    }

    // Accepts different IValidate implementations
    private List<ValidationError> validate(Item item, IValidateItem validateItem) {
        List<ValidationError> list = validateItem.validate(item);
        return list;
    }
}
