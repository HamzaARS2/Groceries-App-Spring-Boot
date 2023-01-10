package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.Customer;
import com.example.groceriesapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/customers")
    public List<Customer> findAllCustomers() {
        return service.getCustomers();
    }

    @PostMapping("/customer/add")
    public Customer addCustomer(@RequestBody Customer customer) {

        return service.insertCustomer(customer);
    }

    @PostMapping("/customer/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return service.insertCustomer(customer);
    }

    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return service.getCustomerById(id);
    }

    @GetMapping("/customer/{docId}")
    public Customer findCustomerByDocId(@PathVariable String docId) {
        return service.getCustomerByDocId(docId);
    }

    @PutMapping
    public Customer updateCustomerByDocId(@PathVariable String docId) {
        return service.updateCustomer(docId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        return service.deleteCustomer(id);
    }



}
