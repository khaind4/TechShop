package com.khaind4.springboot.techshop.exception;

public class RequestApiException extends RuntimeException {
    public RequestApiException(String message) {
        super(message);
    }
}
