package com.thouthworks.felix.services.eureka.sod;

import com.thouthworks.felix.services.eureka.sod.rest.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity notFoundExceptionHandler(NotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}