package com.code.test.demo.exception.product;

import com.code.test.demo.exception.InvalidResourceException;

public class InvalidProductException extends InvalidResourceException {
    public InvalidProductException(String message) {
        super(message);
    }
}
