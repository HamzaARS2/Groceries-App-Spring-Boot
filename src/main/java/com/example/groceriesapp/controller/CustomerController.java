package com.example.groceriesapp.controller;

import com.example.groceriesapp.dto.UpdateTokenRequest;
import com.example.groceriesapp.entity.Customer;
import com.example.groceriesapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> findAllCustomers() {
        return service.getCustomers();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.insertCustomer(customer);
    }

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return service.insertCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable String id) {
        return service.getCustomerById(id);
    }

    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return service.updateCustomer(customer);
    }

    @PutMapping("/token/update/{customerId}")
    public boolean updateCustomerToken(@PathVariable("customerId") String customerId, @RequestBody UpdateTokenRequest tokenRequest){
        return service.updateToken(customerId, tokenRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable String id) {
        return service.deleteCustomer(id);
    }



}
