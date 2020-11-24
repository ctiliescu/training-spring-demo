package com.mobile.academy.trainingspringdemo.evenimente.config;

import com.mobile.academy.trainingspringdemo.evenimente.model.ErrorObject;
import com.mobile.academy.trainingspringdemo.evenimente.model.EvenimentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = {EvenimentNotFound.class})
    public ResponseEntity<ErrorObject> HandleNotFoundException(EvenimentNotFound e) {

        ErrorObject errorObject = new ErrorObject(e.getMessage(), 103);

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);


        //return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);

    }
}
