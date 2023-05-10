package com.example.groceriesapp.service;

import com.example.groceriesapp.entity.Address;
import com.example.groceriesapp.entity.Customer;
import com.example.groceriesapp.repository.AddressRepo;
import com.example.groceriesapp.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {


    @Autowired
    private AddressRepo repository;

    @Autowired
    private CustomerRepo customerRepo;

    public Address saveAddress(Address address, String customerId) {
        Customer customer = customerRepo.findById(customerId).orElse(null);
        if (customer == null) return null;
        Address createdAddress = repository.save(address);
        customer.setAddressId(createdAddress.getId());
        customerRepo.save(customer);
        return createdAddress;
    }

    public Address updateAddress(Address address) {
        Address existingAddress = repository.findById(address.getId()).orElse(null);
        if (existingAddress == null) return null;
        existingAddress.setFirstName(address.getFirstName());
        existingAddress.setLastName(address.getLastName());
        existingAddress.setPhone(address.getPhone());
        existingAddress.setStreetAddress(address.getStreetAddress());
        existingAddress.setCity(address.getCity());
        existingAddress.setState(address.getState());
        existingAddress.setCountry(address.getCountry());
        existingAddress.setLatitude(address.getLatitude());
        existingAddress.setLongitude(address.getLongitude());
        return repository.save(existingAddress);
    }

    public List<Address> getAllAddresses() {
        return repository.findAll();
    }
}
