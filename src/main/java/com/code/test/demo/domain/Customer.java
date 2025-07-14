package com.code.test.demo.domain;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class Customer {
    
    @Digits(integer = 6, fraction = 0 , message = "Id should be up to 6 digits.")
    private int customerId;
    
    @NotNull(message = "Customer name cannot be null.")
    private String name;
    
    @NotNull(message = "Customer email cannot be null.")
    @Email(message = "Customer email is invalid.")
    private String email;

    public Customer(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
