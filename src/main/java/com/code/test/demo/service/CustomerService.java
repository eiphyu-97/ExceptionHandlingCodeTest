package com.code.test.demo.service;

import com.code.test.demo.domain.Customer;

public interface CustomerService {
    void create(Customer customer);
    Customer getCustomerById(int customerId);
    Customer update(Customer customer,int customerId);
    void deleteById(int customerId);
}
