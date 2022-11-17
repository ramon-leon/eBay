package com.example.eBayLatest.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    @Id
    private int siteId;
    private int categoryId;
    private String title;
    private double price;
    private int quantity;

}
