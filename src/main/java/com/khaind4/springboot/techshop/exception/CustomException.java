package com.khaind4.springboot.techshop.exception;

import java.util.Date;

public class CustomException {

    private String message;
    private Date timestamp;
    private String url;

    // Constructor

    public CustomException(String message, Date timestamp, String url) {
        this.message = message;
        this.timestamp = timestamp;
        this.url = url;
    }

    // Getter

    public String getMessage() {
        return message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getUrl() {
        return url;
    }

    // Setter

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
