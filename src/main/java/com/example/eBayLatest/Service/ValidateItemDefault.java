package com.example.eBayLatest.Service;

import com.example.eBayLatest.Model.Item;
import com.example.eBayLatest.Model.ItemEnum;
import com.example.eBayLatest.Model.ValidationError;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidateItemDefault implements IValidateItem{

    @Override
    public List<ValidationError> validate(Item item) {
        List<ValidationError> list = new ArrayList<>();

        if (item.getTitle().length() >= 85) {
            ValidationError e = new ValidationError(ItemEnum.ErrorCustom.TITLE_LENGTH.getCode(),
                    ItemEnum.ErrorCustom.TITLE_LENGTH.getDescription());

            list.add(e);
        }

        if (item.getItemSpecificMap().size() < 2 || item.getItemSpecificMap().size() > 4) {
            ValidationError e = new ValidationError(ItemEnum.ErrorCustom.ITEM_SIZE.getCode(),
                    ItemEnum.ErrorCustom.ITEM_SIZE.getDescription());

            list.add(e);
        }

        if (!(item.getItemSpecificMap().containsKey("Model")
                && item.getItemSpecificMap().get("Model").strip().length() > 0)) {
            ValidationError e = new ValidationError(ItemEnum.ErrorCustom.MISSING_VALUE.getCode(),
                    ItemEnum.ErrorCustom.MISSING_VALUE.getDescription());
            list.add(e);
        }

        return list;
    }
}
