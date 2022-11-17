package com.example.eBayLatest.Service;

import com.example.eBayLatest.Model.Item;
import org.springframework.stereotype.Service;

@Service
public class ShouldValidateItemDefault implements IShouldValidateItem{
    @Override
    public boolean shouldValidateItem(Item item) {
        if (item.getSiteId() >= 0 && item.getSiteId() <= 100)
            return true;
        return false;
    }
}
