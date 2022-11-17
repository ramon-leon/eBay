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
        DATABASE(0, "A database error has occurred."),
        DUPLICATE_USER(1, "This user already exists.");

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