package com.thoughtworks.gtb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResult> handle(UserNotFoundException ex) {
        String timeStamp = new Date().toString();
        Integer status = HttpStatus.NOT_FOUND.value();
        String message = ex.getMessage();
        String error = HttpStatus.NOT_FOUND.getReasonPhrase();

        ErrorResult errorResult = new ErrorResult(timeStamp, status, message, error);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException ex) {
        String timeStamp = new Date().toString();
        Integer status = HttpStatus.BAD_REQUEST.value();
        String message = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        String error = HttpStatus.BAD_REQUEST.getReasonPhrase();

        ErrorResult errorResult = new ErrorResult(timeStamp, status, message, error);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
}
