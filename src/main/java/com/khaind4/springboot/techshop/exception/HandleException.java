package com.khaind4.springboot.techshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(RequestApiException.class)
    public ResponseEntity<?> handleRequestApiException(RequestApiException e, WebRequest webRequest) {
        CustomException customException = new CustomException(e.getMessage(), new Date(), webRequest.getDescription(false));
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException e, WebRequest webRequest) {
        CustomException customException = new CustomException(e.getMessage(), new Date(), webRequest.getDescription(false));
        return new ResponseEntity<>(customException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e, WebRequest webRequest) {
        CustomException customException = new CustomException(e.getMessage(), new Date(), webRequest.getDescription(false));
        return new ResponseEntity<>(customException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
