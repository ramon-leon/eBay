package com.example.eBayLatest.Model;

public class ValidationError {
        int code;
        String description;

        public ValidationError(int code, String description) {
                this.code = code;
                this.description = description;
        }

        public int getCode() {
                return code;
        }

        public void setCode(int code) {
                this.code = code;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

}
