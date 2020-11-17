package com.mobile.academy.trainingspringdemo;

import com.mobile.academy.trainingspringdemo.evenimente.model.EvenimentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Config {
    @ExceptionHandler(value = {EvenimentNotFound.class})
    public ResponseEntity<String> HandleNotFoundException(EvenimentNotFound e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

    }
}
