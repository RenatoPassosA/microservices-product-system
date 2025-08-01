package com.project.productapi.application.exceptions;

public class BusinessException extends RuntimeException{
    
    private final Integer errorCode;

    public BusinessException (String message, Integer errorCode) {

        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
