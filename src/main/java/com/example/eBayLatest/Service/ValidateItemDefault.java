package com.example.eBayLatest.Service;

import com.example.eBayLatest.Model.Item;
import com.example.eBayLatest.Model.ValidationError;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ValidateItemDefault implements IValidateItem{

    @Override
    public List<ValidationError> validate(Item item) {
        List<ValidationError> list = new ArrayList<>();

        if (item.getTitle().length() >= 85) {
            ValidationError e = new ValidationError(100, "Length error" );
            list.add(e);
        }

        if (item.getItemSpecificMap().size() < 2 || item.getItemSpecificMap().size() > 4) {
            ValidationError e = new ValidationError(200, "not between 2 and 4" );
            list.add(e);
        }
        System.out.println("*"+item.getItemSpecificMap().get("Model")+"*");

        if (!(item.getItemSpecificMap().containsKey("Model")
                && item.getItemSpecificMap().get("Model").strip().length() > 0)) {
            ValidationError e = new ValidationError(300, "No mdodel" );
            list.add(e);
        }

        return list;
    }
}
