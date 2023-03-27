package com.example.groceriesapp.controller;

import com.example.groceriesapp.entity.Address;
import com.example.groceriesapp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return service.saveAddress(address);
    }

    @PutMapping
    public Address updateAddress(@RequestBody Address address) {
        return service.updateAddress(address);
    }
}
