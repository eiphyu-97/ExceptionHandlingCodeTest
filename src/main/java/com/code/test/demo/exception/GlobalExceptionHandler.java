package com.code.test.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ExceptionHandler(InvalidResourceException.class)
    public ResponseEntity<ErrorResponse> handleInvalidResourceException(InvalidResourceException ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getClass().getSimpleName(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getClass().getSimpleName(), ex.getMessage());
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status, String errorType, String message) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(status);
        errorResponse.setTimestamp(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new java.util.Date()));
        errorResponse.setErrorType(errorType);
        errorResponse.setDetailedMessage(message);
        return new ResponseEntity<ErrorResponse>(errorResponse, status);
    }


}
