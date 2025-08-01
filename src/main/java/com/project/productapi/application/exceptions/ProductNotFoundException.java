package com.project.productapi.application.exceptions;

public class ProductNotFoundException extends BusinessException {
    
    public ProductNotFoundException(String message) {

        super(message, 404);
    }
}
