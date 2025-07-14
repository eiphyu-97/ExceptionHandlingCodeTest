package com.code.test.demo.exception.product;

import com.code.test.demo.exception.ResourceNotFoundException;

public class ProductNotFoundException extends ResourceNotFoundException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
