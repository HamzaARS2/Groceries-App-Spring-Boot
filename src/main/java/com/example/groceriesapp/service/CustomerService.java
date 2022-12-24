package com.example.groceriesapp.service;

import com.example.groceriesapp.entity.Customer;
import com.example.groceriesapp.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo repository;

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public Customer insertCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer getCustomerById(Integer id) {
        return repository.findById(id).orElse(null);
    }


    public String deleteCustomer(Integer id) {
        repository.deleteById(id);
        return "Customer deleted Successfully : id = " + id;
    }

}
