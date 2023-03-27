package com.example.groceriesapp.service;

import com.example.groceriesapp.entity.Address;
import com.example.groceriesapp.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {


    @Autowired
    private AddressRepo repository;

    public Address saveAddress(Address address) {
        return repository.save(address);
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
        return existingAddress;
    }

    public List<Address> getAllAddresses() {
        return repository.findAll();
    }
}
