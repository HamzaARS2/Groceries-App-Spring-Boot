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

    public Customer getCustomerById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Customer updateCustomer(Customer updatedCustomer) {
        Customer customer = repository.findById(updatedCustomer.getId()).orElse(null);
        if (customer != null) {
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPhone(updatedCustomer.getPhone());
            customer.setAddress(updatedCustomer.getAddress());
            customer.setLocation(updatedCustomer.getLocation());
            return repository.save(customer);
        }

        return null;
    }

    public String deleteCustomer(String id) {
        repository.deleteById(id);
        return "Customer deleted Successfully : id = " + id;
    }

}
