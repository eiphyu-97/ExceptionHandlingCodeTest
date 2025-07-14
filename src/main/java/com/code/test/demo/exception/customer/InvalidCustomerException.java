package com.code.test.demo.exception.customer;

import com.code.test.demo.exception.InvalidResourceException;

public class InvalidCustomerException extends InvalidResourceException {
    public InvalidCustomerException(String message) {
        super(message);
    }
}
