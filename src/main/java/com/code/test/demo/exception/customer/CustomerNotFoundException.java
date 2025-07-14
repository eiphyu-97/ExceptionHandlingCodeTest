package com.code.test.demo.exception.customer;

import com.code.test.demo.exception.ResourceNotFoundException;

public class CustomerNotFoundException extends ResourceNotFoundException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
