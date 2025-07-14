package com.code.test.demo.exception;

public class InvalidResourceException extends RuntimeException{
    public InvalidResourceException(String message) {
        super(message);
    }
}
