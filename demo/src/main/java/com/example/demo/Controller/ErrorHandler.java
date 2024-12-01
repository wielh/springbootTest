package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.grpc.StatusRuntimeException;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleValidationExceptions(ConstraintViolationException ex) {
        StringBuilder errorMessages = new StringBuilder("Validation failed:: ");
        ex.getConstraintViolations().forEach(violation -> errorMessages.append(violation.getPropertyPath())
                .append(": ").append(violation.getMessage()).append("; "));

        return ResponseEntity.badRequest().body(errorMessages.toString());
    }

    @ExceptionHandler(StatusRuntimeException.class)
    public ResponseEntity<String> handleGrpcException(StatusRuntimeException e) {
       return ResponseEntity.status(500).body("An error occurred: " + e.getStatus().getDescription());
    }
}
