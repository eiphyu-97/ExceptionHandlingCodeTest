package com.code.test.demo.service;

import com.code.test.demo.domain.Customer;
import com.code.test.demo.exception.customer.CustomerNotFoundException;
import com.code.test.demo.exception.product.ProductNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private static List<Customer> allCustomers;

    public CustomerServiceImpl() {
        System.out.println("Customer list initialized...");
        allCustomers = new ArrayList<>();
    }

    @Override
    public void create(Customer customer) {
        allCustomers.add(customer);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return allCustomers.stream().filter(cus -> cus.getCustomerId() == customerId).findAny().orElseThrow(() -> new CustomerNotFoundException("Customer is not found by id "+customerId));
    }

    @Override
    public Customer update(Customer customer, int customerId) {
        boolean isRemovalSuccess = allCustomers.removeIf(cust -> customerId == cust.getCustomerId());
        if(isRemovalSuccess) {
            allCustomers.add(customer);
            return customer;
        }
        throw new CustomerNotFoundException("Customer is not found by id " + customerId);
    }

    @Override
    public void deleteById(int customerId) {
        allCustomers.removeIf(cust -> customerId == cust.getCustomerId());
    }

}
