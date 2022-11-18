package com.example.eBayLatest.Model;

public class ItemEnum {
    public enum Condition {
        New(0, "New"),
        Used(1, "Used"),
        Refurbished(2, "Refurbished");

        private final int code;
        private final String description;

        private Condition(int code, String description) {
            this.code = code;
            this.description = description;
        }
    }

    public enum ErrorCustom {
        TITLE_LENGTH(100, "Title length should be less than 85."),
        ITEM_SIZE(101, "item specific items should be between 2 and 4"),
        MISSING_VALUE(102, "Item specific value missing for Model");


        private final int code;
        private final String description;

        private ErrorCustom(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public int getCode() {
            return code;
        }

        @Override
        public String toString() {
            return code + ": " + description;
        }
    }
}