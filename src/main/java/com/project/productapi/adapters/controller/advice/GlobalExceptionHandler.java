package com.project.productapi.adapters.controller.advice;

import com.project.productapi.application.dto.ErrorResponse;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.productapi.application.exceptions.BusinessException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> getException(BusinessException exception) {

        ErrorResponse error = new ErrorResponse(
            exception.getMessage(),
            exception.getErrorCode(),
            LocalDateTime.now());

        return (ResponseEntity
        .status(HttpStatus.valueOf(exception.getErrorCode()))
        .body(error));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> genericException (Throwable exception) {
    
        ErrorResponse error = new ErrorResponse(
            "Internal server error.",
            500,
            LocalDateTime.now());

        return (ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(error));
    }
}
