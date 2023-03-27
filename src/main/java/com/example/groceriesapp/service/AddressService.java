package com.example.groceriesapp.service;

import com.example.groceriesapp.entity.Address;
import com.example.groceriesapp.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {


    @Autowired
    private AddressRepo repository;

    public Integer saveAddress(Address address) {
        return repository.save(address).getId();
    }
}
