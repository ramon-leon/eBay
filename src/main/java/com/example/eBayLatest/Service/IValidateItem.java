package com.example.eBayLatest.Service;

import com.example.eBayLatest.Model.Item;
import com.example.eBayLatest.Model.ValidationError;

import java.util.List;

public interface IValidateItem {
    List<ValidationError> validate(Item item);
}
