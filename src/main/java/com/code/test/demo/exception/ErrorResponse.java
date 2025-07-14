package com.code.test.demo.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private HttpStatus status;
    private String errorType;
    private String timestamp;
    private String detailedMessage;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public void setDetailedMessage(String detailedMessage) {
        this.detailedMessage = detailedMessage;
    }
}
