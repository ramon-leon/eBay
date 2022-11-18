package com.example.eBayLatest.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Map;

//● Define an `Item` object with the following fields. Feel free to browse real inventory on
//        ebay.com to get a better understanding of how real items are structured
//        ○ Site ID
//        ○ Category ID
//        ○ Title
//        ○ Condition
//        ○ Price
//        ○ Quantity
//        ○ Image URL (List)
//        ○ Item Specifics
//        ○ Description
@Entity
public class Item {

    @Id
    private int siteId;
    private int categoryId;
    private String title;
    private ItemEnum.Condition condition;
    private double price;
    private int quantity;
    private String URL;
    private String ItemSpecifics;
    private String description;
    @Transient
    private Map<String,String> ItemSpecificMap;

    public Map<String, String> getItemSpecificMap() {
        return ItemSpecificMap;
    }
    public void setItemSpecificMap(Map<String, String> itemSpecificMap) {
        ItemSpecificMap = itemSpecificMap;
    }

    public ItemEnum.Condition getCondition() {
        return condition;
    }

    public void setCondition(ItemEnum.Condition condition) {
        this.condition = condition;
    }

    public String getItemSpecifics() {
        return ItemSpecifics;
    }

    public void setItemSpecifics(String itemSpecifics) {
        ItemSpecifics = itemSpecifics;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getURL() {
        return URL;
    }
}
