package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.Customer;
import com.example.groceriesapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/all")
    public List<Customer> findAllCustomers() {
        return service.getCustomers();
    }

    @PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {

        return service.insertCustomer(customer);
    }

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return service.insertCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return service.getCustomerById(id);
    }

    @GetMapping("/doc/{docId}")
    public Customer findCustomerByDocId(@PathVariable String docId) {
        return service.getCustomerByDocId(docId);
    }

    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return service.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        return service.deleteCustomer(id);
    }



}
