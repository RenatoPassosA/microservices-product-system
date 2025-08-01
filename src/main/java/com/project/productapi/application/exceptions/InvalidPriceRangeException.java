package com.project.productapi.application.exceptions;

public class InvalidPriceRangeException extends BusinessException {

    public InvalidPriceRangeException(String message) {

        super(message, 400);
    }
}
