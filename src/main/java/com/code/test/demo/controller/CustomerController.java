package com.code.test.demo.controller;

import com.code.test.demo.domain.Customer;

import com.code.test.demo.exception.customer.InvalidCustomerException;
import com.code.test.demo.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/create" , produces = MediaType.TEXT_PLAIN_VALUE)
    public String createCustomer(@RequestBody @Valid Customer customer , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String message = getErrorMessageDetails(bindingResult);
            throw new InvalidCustomerException(message);
        }
        customerService.create(customer);
        return "Created successfully";
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") int customerId){
        System.out.println("Customer id => "+customerId);
        return customerService.getCustomerById(customerId);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody @Valid Customer customer, @PathVariable("id") int customerId , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String message = getErrorMessageDetails(bindingResult);
            throw new InvalidCustomerException(message);
        }
        return customerService.update(customer,customerId);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int customerId){
        customerService.deleteById(customerId);
        return "Deleted Successfully";
    }

    private String getErrorMessageDetails(BindingResult bindingResult){
        return bindingResult.getFieldErrors().stream().map(result -> result.getDefaultMessage())
                .collect(Collectors.joining(" , "));

    }

}
