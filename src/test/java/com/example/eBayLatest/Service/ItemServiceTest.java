package com.example.eBayLatest.Service;

import com.example.eBayLatest.Model.Item;
import com.example.eBayLatest.Model.ItemEnum;
import com.example.eBayLatest.Model.ValidationError;
import com.example.eBayLatest.ServiceExternal.NormalizeItemInput;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ItemServiceTest {
    @Before
    public void setUp() {}
    @Test
    public void normalizeEmpty() {
        NormalizeItemInput normalizeItemInput = new NormalizeItemInput();
        Map<String, String> m = normalizeItemInput.normalizeItemSpecific("");

        assertEquals(m.size(),0);
    }
    @Test
    public void normalizeNull() {
        NormalizeItemInput normalizeItemInput = new NormalizeItemInput();
        Map<String, String> m = normalizeItemInput.normalizeItemSpecific(null);

        assertEquals(m.size(),0);
    }

    @Test
    public void normalizeSingle() {
        NormalizeItemInput normalizeItemInput = new NormalizeItemInput();
        Map<String, String> m = normalizeItemInput.normalizeItemSpecific("BRAND:HONDA");

        assertEquals(m.size(),1);
        assertEquals(m.get("Brand"), "Honda");
    }

    @Test
    public void normalizeMultiple() {
        NormalizeItemInput normalizeItemInput = new NormalizeItemInput();
        Map<String, String> m = normalizeItemInput.normalizeItemSpecific("BRAND:HONDA,Color:bLUE,WIFI:enabled");

        assertEquals(m.size(),3);
        assertEquals(m.get("Brand"), "Honda");
        assertEquals(m.get("Color"), "Blue");
        assertEquals(m.get("Wifi"), "Enabled");
    }

    @Test
    public void normalizeCached() {
        NormalizeItemInput normalizeItemInput = new NormalizeItemInput();
        Map<String, String> m = normalizeItemInput.normalizeItemSpecific("BRAND:HONDA");
        m = normalizeItemInput.normalizeItemSpecific("BRAND:HONDA");

        assertEquals(m.size(),1);
        assertEquals(m.get("Brand"), "Honda");
    }

    @Test
    public void normalizeNonCached() {
        NormalizeItemInput normalizeItemInput = new NormalizeItemInput();

        Map<String, String> m = normalizeItemInput.normalizeItemSpecific("BRAND:HONDA");
        assertEquals(m.size(),1);
        assertEquals(m.get("Brand"), "Honda");

        m = normalizeItemInput.normalizeItemSpecific("brand:honda");  // notice input here is different
        assertEquals(m.size(),1);
        assertEquals(m.get("Brand"), "Honda");
    }

    @Test
    public void shouldValidateExpectTrue() {
        Item item = new Item();
        item.setSiteId(50); // return true if 0 <= siteId <= 100

        ShouldValidateItemDefault shouldValidateItemDefault = new ShouldValidateItemDefault();
        boolean b = shouldValidateItemDefault.shouldValidateItem(item);

        assertEquals(b,true);
    }

    @Test
    public void shouldValidateExpectFalse() {
        Item item = new Item();
        item.setSiteId(101); // return true only if 0 <= siteId <= 100

        ShouldValidateItemDefault shouldValidateItemDefault = new ShouldValidateItemDefault();
        boolean b = shouldValidateItemDefault.shouldValidateItem(item);

        assertEquals(b,false);
    }

    @Test
    public void validateInput_Success() {
        Item item = new Item();
        item.setTitle("Design Patters");
        Map<String,String> map = new HashMap<>();
        map.put("Brand","Ford");
        map.put("Model","Pinto");
        item.setItemSpecificMap(map);
        ValidateItemDefault validateItemDefault = new ValidateItemDefault();

        List<ValidationError> list = validateItemDefault.validate(item);
        assertEquals(list.size(), 0);
    }
    @Test
    public void validateInput_SigleFailure() {
        Item item = new Item();
        item.setTitle("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        Map<String,String> map = new HashMap<>();
        map.put("Brand","Ford");
        map.put("Model","Pinto");
        item.setItemSpecificMap(map);
        ValidateItemDefault validateItemDefault = new ValidateItemDefault();

        List<ValidationError> list = validateItemDefault.validate(item);
        assertEquals(list.size(), 1);
        assertEquals(list.get(0).getCode(), ItemEnum.ErrorCustom.TITLE_LENGTH.getCode());
        assertEquals(list.get(0).getDescription(), ItemEnum.ErrorCustom.TITLE_LENGTH.getDescription());
    }
    @Test
    public void validateInput_AllFailures() {
        Item item = new Item();
        item.setTitle("123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890");
        item.setItemSpecificMap(new HashMap<>());
        ValidateItemDefault validateItemDefault = new ValidateItemDefault();

        List<ValidationError> list = validateItemDefault.validate(item);
        assertEquals(list.size(), 3);
        assertEquals(list.get(0).getCode(), ItemEnum.ErrorCustom.TITLE_LENGTH.getCode());
        assertEquals(list.get(0).getDescription(), ItemEnum.ErrorCustom.TITLE_LENGTH.getDescription());
        assertEquals(list.get(1).getCode(), ItemEnum.ErrorCustom.ITEM_SIZE.getCode());
        assertEquals(list.get(1).getDescription(), ItemEnum.ErrorCustom.ITEM_SIZE.getDescription());
        assertEquals(list.get(2).getCode(), ItemEnum.ErrorCustom.MISSING_VALUE.getCode());
        assertEquals(list.get(2).getDescription(), ItemEnum.ErrorCustom.MISSING_VALUE.getDescription());
    }
}