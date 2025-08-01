package com.project.productapi.application.exceptions;

public class DuplicateProductNameException extends BusinessException {

    public DuplicateProductNameException(String message) {

        super(message, 409);
    }
}