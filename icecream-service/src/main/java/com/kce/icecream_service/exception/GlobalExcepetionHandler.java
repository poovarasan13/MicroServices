package com.kce.icecream_service.exception;


import com.kce.icecream_service.entity.ErrorDetails;
import com.kce.icecream_service.utility.FlavourNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExcepetionHandler {

    @ExceptionHandler(FlavourNotFoundException.class)
    public ResponseEntity<?> handleFlavourNotFound(Exception e, WebRequest request) {
            ErrorDetails errorDetails=new ErrorDetails(new Date(),e.toString(),request.getDescription(false));
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
