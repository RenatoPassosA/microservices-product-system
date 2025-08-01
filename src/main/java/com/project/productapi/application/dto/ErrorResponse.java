package com.project.productapi.application.dto;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String message;
    private Integer errorCode;
    private LocalDateTime timestamp;
 
    public ErrorResponse(String message, Integer errorCode, LocalDateTime timestamp) {
        
        this.message = message;
        this.errorCode = errorCode;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
