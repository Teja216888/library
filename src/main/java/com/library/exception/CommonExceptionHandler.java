package com.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CommonExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MaxBooksException.class)
    public ResponseEntity<String> ValidatePostException(MaxBooksException e){
        return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
